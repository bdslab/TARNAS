package it.unicam.cs.bdslab.tarnas.view.cli;

import it.unicam.cs.bdslab.tarnas.controller.CleanerController;
import it.unicam.cs.bdslab.tarnas.controller.IOController;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFile;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFileException;
import picocli.CommandLine.ParentCommand;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;

import java.util.ArrayList;
import java.util.List;

@Command(
        name = "cleaning",
        mixinStandardHelpOptions = true,
        description = "Cleans the input based on the selected cleaning option",
        version = "TARNAS 1.0"
)
public class CleaningCommand implements Runnable {

    private IOController ioController;

    private CleanerController cleanerController;

    private List<RNAFile> cleanedFiles;
    @ParentCommand
    private CLIController parent;

    @Option(names = {"--comments"}, description = "Remove all comments from the input file")
    private boolean removeComments;

    @Option(names = {"--lines"}, description = "Remove lines containing an input string from the input file")
    private String stringToBeRemoved;

    @Option(names = {"--empty"}, description = "Remove all empty lines from the input file")
    private boolean removeEmptyLines;

    @Option(names = {"--merge"}, description = "Merge all lines in the input file only for DOT_BRACKET and DB_NO_SEQUENCE formats")
    private boolean mergeLines;

    public CleaningCommand() {
        this.ioController = IOController.getInstance();
        this.cleanerController = CleanerController.getInstance();
        cleanedFiles = new ArrayList<>();
        this.removeComments = false;
        this.stringToBeRemoved = null;
        this.removeEmptyLines = false;
        this.mergeLines = false;
    }

    private void cleanFiles() {
        try {
            this.cleanedFiles = this.cleanerController.clean(this.ioController.getLoadedRNAFiles(), this.removeComments,
                    this.stringToBeRemoved, this.removeEmptyLines, this.mergeLines);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }


    }

    @Override
    public void run() {
        this.cleanFiles();
        this.parent.saveFiles(this.cleanedFiles);
    }
}
