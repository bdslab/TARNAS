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

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

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
    private CLIController parent;

    // Translation options
    @Parameters(index = "0", description = "Destination Format options (case-sensitive): AAS, AAS_NO_SEQUENCE, BPSEQ, CT, DB, DB_NO_SEQUENCE, FASTA, RNAML.")
    private RNAFormat destinationFormat;

    @Option(names = {"--no-header"}, description = "Exclude the header from the output during translation.")
    private boolean excludeHeader;

    // generate non canonical pairs (only for RNAML input format)
    @Option(names = {"--non-canonical-pairs"}, description = "Generate non canonical pairs, if there are (only for RNAML input format).")
    private boolean generateNonCanonicalPairs;


    public TranslateCommand() {
        this.cleanerController = CleanerController.getInstance();
        this.translatorController = TranslatorController.getInstance();
        this.ioController = IOController.getInstance();
        this.translatedFiles = new ArrayList<>();
        this.excludeHeader = false;
        this.generateNonCanonicalPairs = false;
        this.destinationFormat = null;
    }

    private List<RNAFile> translateFiles(List<RNAFile> files) throws RNAFileException {
        List<RNAFile> translatedRNAFiles;
        translatedRNAFiles = this.translatorController.translateAllLoadedFiles(files, this.destinationFormat);
        if (this.excludeHeader)
            translatedRNAFiles = translatedRNAFiles.parallelStream()
                    .map(this.cleanerController::removeHeader)
                    .toList();
        return translatedRNAFiles;
    }

    private void translate() {
        try {
            this.translatedFiles = this.translateFiles(this.ioController.getLoadedRNAFiles());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }


    @Override
    public void run() {
        this.translate();
        this.parent.saveFiles(this.translatedFiles,this.generateNonCanonicalPairs);
    }

}
