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
                AAS, List.of(AAS, AAS_NO_SEQUENCE, BPSEQ, CT, DB, DB_NO_SEQUENCE, FASTA, RNAML),
                AAS_NO_SEQUENCE, List.of(DB_NO_SEQUENCE),
                BPSEQ, List.of(AAS, AAS_NO_SEQUENCE, CT, DB, DB_NO_SEQUENCE, FASTA, RNAML),
                CT, List.of(AAS, AAS_NO_SEQUENCE, BPSEQ, DB, DB_NO_SEQUENCE, FASTA, RNAML),
                DB, List.of(AAS, AAS_NO_SEQUENCE, DB, BPSEQ, CT, DB_NO_SEQUENCE, FASTA, RNAML),
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
        return (rnaFormat == AAS || rnaFormat == DB)
                ? this.conversionMatrix.get(rnaFormat).stream()
                .filter(t -> t != rnaFormat)
                .toList()
                : this.conversionMatrix.get(rnaFormat);
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
        try {
            for (var f : rnaFiles) {
                tmp = f;
                translatedtedLoadedRNAFiles.add(this.translateTo(f, dstRNAFormat));
            }
        } catch (Exception e) {
            throw new RNAFileException("Error caused by file: " + tmp.getFileName());
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
        RNAFormat srcFormat = rnaFile.getFormat();
        // Check if translation is supported
        if (!conversionMatrix.get(srcFormat).contains(dstRNAFormat)) {
            throw new RNAFormatTranslationException("Cannot translate from " + srcFormat + " to " + dstRNAFormat);
        }
        RNAFile formattedRNAFile;
        if (srcFormat == RNAML || dstRNAFormat == RNAML) {
            formattedRNAFile = handleRnamlTranslation(rnaFile, srcFormat.getExtension(), dstRNAFormat.getExtension());
            if (dstRNAFormat == AAS_NO_SEQUENCE)
                formattedRNAFile = noCheckingTranslateTo(formattedRNAFile, AAS_NO_SEQUENCE);
            if (dstRNAFormat == DB_NO_SEQUENCE)
                formattedRNAFile = noCheckingTranslateTo(formattedRNAFile, DB_NO_SEQUENCE);
        } else {
            // Standard translation
            formattedRNAFile = noCheckingTranslateTo(rnaFile, dstRNAFormat);
        }
        return formattedRNAFile;
    }

    private RNAFile handleRnamlTranslation(RNAFile rnaFile, String inputExtension, String outputExtension) throws IOException {
        Path inputFilePath = Path.of(rnaFile.getFileName().split("\\.")[0] + "." + inputExtension);
        Path outputFilePath = Path.of(rnaFile.getFileName().split("\\.")[0] + "." + outputExtension);

        if (inputExtension.equals("aas")) {
            rnaFile = this.noCheckingTranslateTo(rnaFile, AAS);
        } else if (inputExtension.equals("db")) {
            rnaFile = this.noCheckingTranslateTo(rnaFile, DB);
        }
        Files.write(inputFilePath, rnaFile.getContent());

        var controller = new RnaParserAnalyzerController();
        var loadSuccessful = controller.loadRna(inputFilePath.toString()).result;

        if (loadSuccessful) {
            controller.SaveLoadedData(outputFilePath.toString());
        }
        try {
            return RNAFileConstructor.getInstance().construct(outputFilePath);
        } catch (Exception e) {
            Files.deleteIfExists(Path.of(inputFilePath + ".csv"));
            throw new IOException();
        } finally {
            // Delete files after use
            Files.deleteIfExists(inputFilePath);
            Files.deleteIfExists(outputFilePath);
        }
    }

    /**
     * Useful method to translate an {@link RNAFile} to the specified {@code rnaFormat} without translation checking.
     *
     * @param rnaFile   the {@code RNAFile} to translate.
     * @param rnaFormat the destination {@link RNAFormat}
     * @return the {@link RNAFile} that represent the translation of the specified {@code rnaFile}
     * in the destination {@code rnaFormat}
     */
    private RNAFile noCheckingTranslateTo(RNAFile rnaFile, RNAFormat rnaFormat) {
        return switch (rnaFormat) {
            case AAS -> RNAFileTranslator.translateToAAS(rnaFile);
            case AAS_NO_SEQUENCE -> RNAFileTranslator.translateToAASNoSequence(rnaFile);
            case BPSEQ -> RNAFileTranslator.translateToBPSEQ(rnaFile);
            case CT -> RNAFileTranslator.translateToCT(rnaFile);
            case DB -> RNAFileTranslator.translateToDB(rnaFile);
            case DB_NO_SEQUENCE -> RNAFileTranslator.translateToDBNoSequence(rnaFile);
            case FASTA -> RNAFileTranslator.translateToFASTA(rnaFile);
            // dummy case, case handled in another function
            case RNAML -> null;
        };
    }
}
