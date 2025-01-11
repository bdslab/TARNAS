package it.unicam.cs.bdslab.tarnas.view.cli;

import it.unicam.cs.bdslab.tarnas.controller.IOController;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFile;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * CLIController class that handles the command line interface.
 *
 * @pico.cli.command.Parameters index = "0" description = "Input RNA file path or RNA directory path"
 * @pico.cli.command.Parameters index = "1" description = "Output directory path"
 * @pico.cli.command.Option names = "--zip" description = "Save files as a zip file with the given name at the <outputDirectoryPath>"
 * @see TranslateCommand
 * @see CleaningCommand
 * @see AbstractionsCommand
 * <p>
 * This class is the main @code{picocli.CommandLine.Command} class that handles the command line interface.
 * It is responsible for parsing the input arguments and executing the commands.
 * <p>
 * The class is also responsible for loading the input RNA file or directory and checking the output directory.
 * <p>
 * The class also provides a method to save the translated RNA files to the output directory.
 */
@Command(
        name = "TARNAS_CLI.jar",
        mixinStandardHelpOptions = true,
        version = "TARNAS 1.0",
        description = """
        TARNAS: a TrAnslator for RNA Secondary Structure formats.

        USAGE EXAMPLES:
        1. Translate RNA file:
           java -jar TARNAS_CLI.jar <inputPath> <outputDirectoryPath> translate --no-header RNAML

        2. Clean RNA file by removing comments:
           java -jar TARNAS_CLI.jar <inputPath> <outputDirectoryPath> cleaning --comments

        3. Compute abstractions (core, coreplus and shape):
           java -jar TARNAS_CLI.jar <inputPath> <outputDirectoryPath> abstractions --core --coreplus --shape

        4. Save translated RNA file as a zip:
           java -jar TARNAS_CLI.jar <inputPath> <outputDirectoryPath> --zip <zipFileName> translate RNAML
        """,
        subcommands = {TranslateCommand.class, CleaningCommand.class, AbstractionsCommand.class}
)

public class CLIController implements Runnable {

    private final IOController ioController;

    @Parameters(index = "0", description = "Input RNA file path or RNA directory path")
    private String inputPath;

    // Output RNA directory path
    @Parameters(index = "1", description = "Output directory path")
    private String outputDirectoryPath;

    @Option(names = "--zip", description = "Save files as a zip file with the given name at the <outputDirectoryPath>", defaultValue = "")
    private String zipFileName;

    /**
     * Builds a new CLIController instance.
     */
    public CLIController() {
        this.ioController = IOController.getInstance();
        this.zipFileName = null;
    }

    /**
     * Adds a file or a folder containing RNA files, to the CLIController.
     *
     * @param p the path of the file or the folder to add
     */
    private void addFile(Path p) {
        if (!Files.exists(p)) {
            System.err.println("Non existent file with path: " + p);
            System.exit(1);
        }
        try {
            if (Files.isRegularFile(p))
                loadPath(p, "file");
            if (Files.isDirectory(p))
                loadPath(p, "folder");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Loads a file or a directory containing RNA files.
     *
     * @param p    the path of the file or the folder to load
     * @param type the type of the path (file or directory)
     * @throws IOException if an I/O error occurs
     */
    private void loadPath(Path p, String type) throws IOException {
        if (type.equals("file"))
            ioController.loadFile(p);
        else
            ioController.loadDirectory(p);
    }

    /**
     * Checks if the output directory exists.
     *
     * @param p the path of the output directory
     */
    private void checkOutputDirectory(Path p) {
        if (!Files.exists(p)) {
            System.err.println("Non existent directory with path: " + p);
            System.exit(1);
        }
        if (!Files.isDirectory(p)) {
            System.err.println(p + " is not a directory");
            System.exit(1);
        }
    }

    /**
     * Runs the CLIController.
     */
    @Override
    public void run() {
        addFile(Path.of(inputPath));
        checkOutputDirectory(Path.of(outputDirectoryPath));
    }


    /**
     * Saves the given list of {@link RNAFile} objects to the output directory path using the {@code ioController}.
     * If an error occurs it is logged to the standard error stream and the application terminates with code {@code 1}.
     *
     * @param files                     the list of {@link RNAFile} objects to save
     * @param generateNonCanonicalPairs whether to process non-canonical pairs
     * @param generateStatistics        whether to generate statistics for each file
     */
    public void saveFiles(List<RNAFile> files,
                          boolean generateNonCanonicalPairs,
                          boolean generateStatistics) {
        try {
            ioController.saveFiles(
                    files,
                    Path.of(outputDirectoryPath),
                    generateNonCanonicalPairs,
                    generateStatistics,
                    zipFileName
            );
        } catch (Exception e) {
            System.err.println("Error while saving files");
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

}
