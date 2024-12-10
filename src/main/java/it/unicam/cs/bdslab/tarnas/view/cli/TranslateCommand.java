package it.unicam.cs.bdslab.tarnas.view.cli;

import it.unicam.cs.bdslab.tarnas.controller.CleanerController;
import it.unicam.cs.bdslab.tarnas.controller.IOController;
import it.unicam.cs.bdslab.tarnas.controller.TranslatorController;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFile;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFileException;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFormat;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;
import picocli.CommandLine.Option;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the command that translates the input to the specified destination format.
 *
 * @see CLIController
 *
 * This class is a @code{picocli.CommandLine.Command} class that represents the command that translates the input to the specified destination format.
 *
 * The class is responsible for parsing the input arguments and executing the command.
 *
 * The class is also responsible for translating the input RNA files to the specified destination format.
 *
 * @pico.cli.command.Option names = "--no-header" description = "Exclude the header from the output during translation."
 *
 * @pico.cli.command.Option names = "--non-canonical-pairs" description = "Generate non canonical pairs, if there are (only for RNAML input format)."
 *
 * @pico.cli.command.Parameters index = "0" description = "Destination Format options (case-sensitive): AAS, AAS_NO_SEQUENCE, BPSEQ, CT, DB, DB_NO_SEQUENCE, FASTA, RNAML."
 *
 * @pico.cli.command.Command(name = "translate", mixinStandardHelpOptions = true, description = "Translate the input to the specified destination format.", version = "TARNAS 1.0")
 *
 * @pico.cli.command.ParentCommand CLIController
 *
 */
@Command(
        name = "translate",
        mixinStandardHelpOptions = true,
        description = "Translate the input to the specified destination format.",
        version = "TARNAS 1.0"
)
public class TranslateCommand implements Runnable {

    private final IOController ioController;

    private final CleanerController cleanerController;

    private final TranslatorController translatorController;

    private List<RNAFile> translatedFiles;

    @ParentCommand
    private CLIController parentCommand;

    // Translation options
    @Parameters(index = "0", description = "Destination Format options (case-sensitive): AAS, AAS_NO_SEQUENCE, BPSEQ, CT, DB, DB_NO_SEQUENCE, FASTA, RNAML.")
    private RNAFormat destinationFormat;

    @Option(names = {"--no-header"}, description = "Exclude the header from the output during translation.")
    private boolean excludeHeader;

    // generate non canonical pairs (only for RNAML input format)
    @Option(names = {"--non-canonical-pairs"}, description = "Generate non canonical pairs, if there are (only for RNAML input format).")
    private boolean generateNonCanonicalPairs;


    /**
     * Builds a new TranslateCommand instance.
     */
    public TranslateCommand() {
        this.cleanerController = CleanerController.getInstance();
        this.translatorController = TranslatorController.getInstance();
        this.ioController = IOController.getInstance();
        this.translatedFiles = new ArrayList<>();
        this.excludeHeader = false;
        this.generateNonCanonicalPairs = false;
        this.destinationFormat = null;
    }

    /**
     * Translates the input RNA files to the specified destination format.
     * @param files the input RNA files
     * @return the translated RNA files
     * @throws RNAFileException if an error occurs during the translation
     */
    private List<RNAFile> translateFiles(List<RNAFile> files) throws RNAFileException {
        List<RNAFile> translatedRNAFiles;
        translatedRNAFiles = this.translatorController.translateAllLoadedFiles(files, this.destinationFormat);
        if (this.excludeHeader)
            translatedRNAFiles = translatedRNAFiles.parallelStream()
                    .map(this.cleanerController::removeHeader)
                    .toList();
        return translatedRNAFiles;
    }

    /**
     * Translates the input RNA files to the specified destination format.
     */
    private void translate() {
        try {
            this.translatedFiles = this.translateFiles(this.ioController.getLoadedRNAFiles());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Runs the command that translates the input to the specified destination format.
     */
    @Override
    public void run() {
        this.translate();
        this.parentCommand.saveFiles(this.translatedFiles, this.generateNonCanonicalPairs);
    }

}
