package it.unicam.cs.bdslab.tarnas.view.cli;

import it.unicam.cs.bdslab.tarnas.controller.CleanerController;
import it.unicam.cs.bdslab.tarnas.controller.IOController;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFile;
import picocli.CommandLine.ParentCommand;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the command that cleans the input based on the selected cleaning option.
 *
 * @pico.cli.command.Option names = "--comments" description = "Remove all comments from the input file"
 * @pico.cli.command.Option names = "--lines" description = "Remove lines containing an input string from the input file"
 * @pico.cli.command.Option names = "--empty" description = "Remove all empty lines from the input file"
 * @pico.cli.command.Option names = "--merge" description = "Merge all lines in the input file only for DOT_BRACKET and DB_NO_SEQUENCE formats"
 * @pico.cli.command.Command(name = "cleaning", mixinStandardHelpOptions = true, description = "Cleans the input based on the selected cleaning option", version = "TARNAS 1.0")
 * @pico.cli.command.ParentCommand CLIController
 * @see CLIController
 * <p>
 * This class is a @code{picocli.CommandLine.Command} class that represents the command that cleans the input based on the selected cleaning option.
 * <p>
 * The class is responsible for parsing the input arguments and executing the command.
 * <p>
 * The class is also responsible for cleaning the input RNA files based on the selected cleaning option.
 */
@Command(
        name = "cleaning",
        mixinStandardHelpOptions = true,
        description = "Cleans the input based on the selected cleaning option",
        version = "TARNAS 1.0"
)
public class CleaningCommand implements Runnable {

    private final IOController ioController;

    private final CleanerController cleanerController;

    private final List<RNAFile> cleanedFiles;

    @ParentCommand
    private CLIController parent;

    @Option(names = {"--comments"}, description = "Remove all comments from the input file", defaultValue = "false")
    private boolean removeComments;

    @Option(names = {"--lines"}, description = "Remove lines containing an input string from the input file", defaultValue = "null")
    private String stringToBeRemoved;

    @Option(names = {"--empty"}, description = "Remove all empty lines from the input file", defaultValue = "false")
    private boolean removeEmptyLines;

    @Option(names = {"--merge"}, description = "Merge all lines in the input file only for DOT_BRACKET and DB_NO_SEQUENCE formats", defaultValue = "false")
    private boolean mergeLines;

    /**
     * Builds a new CleaningCommand instance.
     */
    public CleaningCommand() {
        this.ioController = IOController.getInstance();
        this.cleanerController = CleanerController.getInstance();
        cleanedFiles = new ArrayList<>();
    }

    /**
     * Cleans the input RNA files based on the selected cleaning option.
     */
    private void cleanFiles() {
        for (var f : ioController.getLoadedRNAFiles()) {
            try {
                // Clean the file using the specified options
                var cleanedFile = cleanerController.clean(
                        f, removeComments, stringToBeRemoved, removeEmptyLines, mergeLines);
                cleanedFiles.add(cleanedFile);
            } catch (Exception e) {
                System.err.println("Error caused by: " + f.getFileName());
                System.err.println(e.getMessage());
                System.exit(1);
            }
        }
    }

    /**
     * Runs the command that cleans the input based on the selected cleaning option.
     */
    @Override
    public void run() {
        cleanFiles();
        parent.saveFiles(cleanedFiles, false, false);
    }
}
