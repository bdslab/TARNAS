package it.unicam.cs.bdslab.tarnas.controller;

import static it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFormat.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import it.unicam.cs.bdslab.rnamlparsertool.controller.RnaParserAnalyzerController;
import it.unicam.cs.bdslab.tarnas.model.rnafile.*;
import it.unicam.cs.bdslab.tarnas.model.rnastructure.RNASecondaryStructure;

/**
 * // TODO: javadoc
 * An implementation of Translator Controller that accepts input from the {@link IOController} and converts that
 * input to commands for the Model or View.
 * This Controller takes care translation operations and file loading/saving/deleting and directory loading/saving.
 * In particular, it provides paralleled translation operations when multiple files are loaded, to have better performance.
 * Moreover, this Controller executes checking for I/O errors.
 *
 * @author Piero Hierro, Piermichele Rosati
 * @see RNAFile
 * @see Stream#parallel()
 */
public class TranslatorController {

    private static TranslatorController instance;

    /**
     * This conversion matrix has the X {@link RNAFormat} as key-map and
     * every key has the list of possible Y, Z, W destination {@code RNAFormat} to which convert X, as value-map.
     */
    private final Map<RNAFormat, List<RNAFormat>> conversionMatrix;

    /**
     * Creates a Translator Controller.
     * It initializes the conversion matrix for translation operations.
     */
    private TranslatorController() {
        conversionMatrix = Map.of(
                AAS, List.of(AAS_NO_SEQUENCE, BPSEQ, CT, DB, DB_NO_SEQUENCE, FASTA, RNAML),
                AAS_NO_SEQUENCE, List.of(DB_NO_SEQUENCE),
                BPSEQ, List.of(AAS, AAS_NO_SEQUENCE, CT, DB, DB_NO_SEQUENCE, FASTA, RNAML),
                CT, List.of(AAS, AAS_NO_SEQUENCE, BPSEQ, DB, DB_NO_SEQUENCE, FASTA, RNAML),
                DB, List.of(AAS, AAS_NO_SEQUENCE, BPSEQ, CT, DB_NO_SEQUENCE, FASTA, RNAML),
                DB_NO_SEQUENCE, List.of(AAS_NO_SEQUENCE),
                FASTA, List.of(),
                RNAML, List.of(AAS, AAS_NO_SEQUENCE, BPSEQ, CT, DB, DB_NO_SEQUENCE, FASTA));
    }

    /**
     * Return available translations from a {@link RNAFormat}
     *
     * @param rnaFormat an {@link RNAFormat}
     * @return list of {@link RNAFormat}
     */
    public List<RNAFormat> getAvailableTranslations(RNAFormat rnaFormat) {
        return this.conversionMatrix.get(rnaFormat);
    }

    /**
     * Factory method for the obtaining the {@link TranslatorController} instance.
     *
     * @return the instance of this Singleton
     */
    public static TranslatorController getInstance() {
        if (instance == null)
            instance = new TranslatorController();
        return instance;
    }

    /**
     * Translates all files corresponding specified file paths to the specified {@code dstRNAFormat} and
     * returns the list of all translated loaded files.
     *
     * @param rnaFiles     the list of file paths to translate
     * @param dstRNAFormat the destination {@link RNAFormat} to which translate all loaded files.
     * @return the list of all translated loaded files
     */
    public List<RNAFile> translateAllLoadedFiles(List<RNAFile> rnaFiles, RNAFormat dstRNAFormat) throws RNAFileException {
        List<RNAFile> translatedtedLoadedRNAFiles = new ArrayList<>();
        RNAFile tmp = null;
        try{
            for (var f: rnaFiles){
                tmp = f;
                translatedtedLoadedRNAFiles.add(this.translateTo(f,dstRNAFormat));
            }
        }catch (Exception e) {
            throw new RNAFileException("Error caused by file: "+ tmp.getFileName());
        }
        return translatedtedLoadedRNAFiles;
    }

    /**
     * Translates the specified {@link RNAFile} to the specified {@code dstRNAFormat} and
     * returns the {@link RNAFile} that represents the translated specified {@code rnaFile}.
     *
     * @param rnaFile      the {@code RNAFile} to translate to the specified {@code dstRNAFormat}.
     * @param dstRNAFormat the destination {@link RNAFormat} to which translate the specified {@code rnaFile}
     * @return the {@code FormattedRNAFile}, so the translation of the specified {@code rnaFile}
     * @throws RNAFormatTranslationException if a translation error occurs
     */
    private RNAFile translateTo(RNAFile rnaFile, RNAFormat dstRNAFormat) throws RNAFormatTranslationException, IOException {
        RNAFile formattedRNAFile;
        if (rnaFile.getFormat() == RNAML || dstRNAFormat == RNAML)
            return this.handleRnamlTranslation(rnaFile, rnaFile.getFormat().getExtension(), dstRNAFormat.getExtension());

        if (this.conversionMatrix.get(rnaFile.getFormat()).contains(dstRNAFormat))
            formattedRNAFile = this.noCheckingtranslateTo(rnaFile, dstRNAFormat);
        else
            throw new RNAFormatTranslationException("Cannot translate from " + rnaFile.getFormat() + " to " + dstRNAFormat);
        return formattedRNAFile;
    }

    private RNAFile handleRnamlTranslation(RNAFile rnaFile, String inputExtension, String outputExtension) throws IOException {
        // write the list of strings to the temporary file
        var input = "input." + inputExtension;
        var inputFilePath = Path.of(input);
        Files.write(inputFilePath, rnaFile.getContent());
        var controller = new RnaParserAnalyzerController();
        var result = controller.loadRna(input);
        var output = rnaFile.getFileName().substring(0, rnaFile.getFileName().lastIndexOf('.') + 1) + outputExtension;
        if (result.result) {
            controller.SaveLoadedData(output);
        }
        Path outputFilePath = Path.of(output);
        rnaFile = RNAFileConstructor.getInstance().construct(outputFilePath);
        // delete input and output files
        Files.delete(outputFilePath);
        Files.delete(inputFilePath);
        return rnaFile;
    }

    /**
     * Useful method to translate an {@link RNAFile} to the specified {@code rnaFormat} without translation checking.
     *
     * @param rnaFile   the {@code RNAFile} to translate.
     * @param rnaFormat the destination {@link RNAFormat}
     * @return the {@link RNAFile} that represent the translation of the specified {@code rnaFile}
     * in the destination {@code rnaFormat}
     */
    private RNAFile noCheckingtranslateTo(RNAFile rnaFile, RNAFormat rnaFormat) {
        return switch (rnaFormat) {
            case AAS -> RNAFileTranslator.translateToAAS(rnaFile);
            case AAS_NO_SEQUENCE -> RNAFileTranslator.translateToAASNoSequence(rnaFile);
            case BPSEQ -> RNAFileTranslator.translateToBPSEQ(rnaFile);
            case CT -> RNAFileTranslator.translateToCT(rnaFile);
            case DB -> RNAFileTranslator.translateToDB(rnaFile);
            case DB_NO_SEQUENCE -> RNAFileTranslator.translateToDBNoSequence(rnaFile);
            case FASTA -> RNAFileTranslator.translateToFASTA(rnaFile);
            // dummy case, case handle in another function
            case RNAML -> null;
        };
    }
}
