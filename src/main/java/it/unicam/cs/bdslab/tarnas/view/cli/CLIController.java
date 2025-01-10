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
        description = "TARNAS: a TrAnslator for RNA Secondary Structure formats.\n\n" +
                "USAGE EXAMPLES:\n" +
                "1. Translate RNA file:\n" +
                "   java -jar TARNAS_CLI.jar <inputPath> <outputDirectoryPath> translate --no-header RNAML\n\n" +
                "2. Clean RNA file by removing comments:\n" +
                "   java -jar TARNAS_CLI.jar <inputPath> <outputDirectoryPath> cleaning --comments\n\n" +
                "3. Compute abstractions (core, coreplus and shape):\n" +
                "   java -jar TARNAS_CLI.jar <inputPath> <outputDirectoryPath> abstractions --core --coreplus --shape\n\n" +
                "4. Save translated RNA file as a zip:\n" +
                "   java -jar TARNAS_CLI.jar <inputPath> <outputDirectoryPath> --zip output.zip translate RNAML\n\n",
        subcommands = {TranslateCommand.class, CleaningCommand.class, AbstractionsCommand.class}
)
public class CLIController implements Runnable {

    private final IOController ioController;

    @Parameters(index = "0", description = "Input RNA file path or RNA directory path")
    private String inputPath;

    // Output RNA directory path
    @Parameters(index = "1", description = "Output directory path")
    private String outputDirectoryPath;

    @Option(names = "--zip", description = "Save files as a zip file with the given name at the <outputDirectoryPath>")
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
            this.ioController.loadFile(p);
        else
            this.ioController.loadDirectory(p);

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
        this.addFile(Path.of(this.inputPath));
        this.checkOutputDirectory(Path.of(this.outputDirectoryPath));
    }

    /**
     * Saves the translated RNA files to the output directory.
     *
     * @param files                     the list of RNA files to save
     * @param generateNonCanonicalPairs whether to generate non-canonical pairs (only for RNAML input format)
     */
    protected void saveFiles(List<RNAFile> files, boolean generateNonCanonicalPairs) {
        var outputDirectory = Path.of(this.outputDirectoryPath);
        try {
            if (this.zipFileName != null) {
                this.ioController.zipFiles(outputDirectory, this.zipFileName, files, generateNonCanonicalPairs);
            } else {
                this.ioController.saveFilesTo(files, outputDirectory, generateNonCanonicalPairs);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Saves the translated RNA files to the output directory.
     *
     * @param files the list of RNA files to save
     */
    protected void saveFiles(List<RNAFile> files) {
        this.saveFiles(files, false);
    }

    /**
     * Saves the abstractions to the output directory.
     *
     * @param abstractions the list of abstractions to save
     */
    protected void saveAbstractions(List<RNAFile> abstractions) {
        try {
            this.ioController.saveAbstractions(abstractions, Path.of(this.outputDirectoryPath));
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

    }

}
