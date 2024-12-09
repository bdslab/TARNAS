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


@Command(
        name = "TARNAS_CLI.jar",
        mixinStandardHelpOptions = true,
        version = "TARNAS 1.0",
        description = "A simple CLI tool for RNA file format conversion.",
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


    public CLIController() {
        this.ioController = IOController.getInstance();
        this.zipFileName = null;
    }


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
        System.exit(1);
    }

    private void loadPath(Path p, String type) throws IOException {
        if (type.equals("file"))
            this.ioController.loadFile(p);
        else
            this.ioController.loadDirectory(p);

    }

    private void checkOutputDirectory(Path p) {
        // check if the output directory exists
        if (!Files.exists(p)) {
            System.err.println("Non existent directory with path: " + p);
            System.exit(1);
        }
        if (!Files.isDirectory(p)) {
            System.err.println(p + " is not a directory");
            System.exit(1);
        }
    }

    @Override
    public void run() {
        this.addFile(Path.of(this.inputPath));
        this.checkOutputDirectory(Path.of(this.outputDirectoryPath));
    }

    protected void saveFiles(List<RNAFile> files, boolean generateNonCanonicalPairs) {
        var outputDirectory = Path.of(this.outputDirectoryPath);
        try {
            if (this.zipFileName != null)
                this.ioController.zipFiles(outputDirectory, this.zipFileName, files, generateNonCanonicalPairs);
            else
                this.ioController.saveFilesTo(files, outputDirectory, generateNonCanonicalPairs);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    protected void saveFiles(List<RNAFile> files) {
        var outputDirectory = Path.of(this.outputDirectoryPath);
        try {
            if (this.zipFileName != null)
                this.ioController.zipFiles(outputDirectory, this.zipFileName, files, false);
            else
                this.ioController.saveFilesTo(files, outputDirectory, false);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

}
