package it.unicam.cs.bdslab.tarnas.view.cli;
//D:\UNIVERSITA\paper_tarnas\TARNAS\src\test\resources\datasets\aspralignTest\edbn\CRW_00808.db C:\Users\newxp\OneDrive\Desktop -t AAS --no-header false
//D:\UNIVERSITA\paper_tarnas\TARNAS\src\test\resources\datasets\aspralignTest\edbn\CRW_00808.db C:\Users\newxp\OneDrive\Desktop translate

import it.unicam.cs.bdslab.tarnas.controller.AbstractionsController;
import it.unicam.cs.bdslab.tarnas.controller.CleanerController;
import it.unicam.cs.bdslab.tarnas.controller.IOController;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFile;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFormat;
// nome.jar <input> <output> translate
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
        subcommands = {TranslateCommand.class, CleaningCommand.class}
)
public class CLIController implements Runnable {

    private final IOController ioController;

    private final AbstractionsController abstractionsController;

    @Parameters(index = "0", description = "Input RNA file path or RNA directory path")
    private String inputPath;

    // Output RNA directory path
    @Parameters(index = "1", description = "Output directory path")
    private String outputDirectoryPath;

    @Option(names = "--zip", description = "Save files as a zip file with the given name at the <outputDirectoryPath>")
    private String zipFileName;


    // Abstraction options

    // generate core
    /*@Option(names = {"-g", "--generate"}, description = "Generate core")
    private boolean generateCore;

    // generate coreplus
    @Option(names = {"-G", "--generate-plus"}, description = "Generate coreplus")
    private boolean generateCorePlus;

    // generate shape
    @Option(names = {"-s", "--shape"}, description = "Generate shape")
    private boolean generateShape;*/

    public CLIController() {
        // init controllers
        this.ioController = IOController.getInstance();
        this.abstractionsController = AbstractionsController.getInstance();
        // Default options
        this.zipFileName = null;
    }


    private void addFile(Path p) {
        if (!Files.exists(p)) {
            System.err.println("Non existent file with path: " + p);
            System.exit(1);
        }
        try {
            if (Files.isRegularFile(p)) {
                loadPath(p, "file");
            }
            if (Files.isDirectory(p)) {
                loadPath(p, "folder");
            }
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

    /*public List<RNAFile> clean(List<RNAFile> files) throws RNAFileException {
        var cleanedFiles = new ArrayList<RNAFile>();
        RNAFile tmp = null;
        try {
            for (var f : files) {
                tmp = f;
                if (this.removeComments) {
                    f = this.cleanerController.removeLinesStartingWith(f, "#");
                    f = this.cleanerController.removeLinesStartingWith(f, ">");
                }
                if (this.stringToBeRemoved != null)
                    f = this.cleanerController.removeLinesContaining(f, stringToBeRemoved);
                if (this.removeEmptyLines)
                    f = this.cleanerController.removeWhiteSpaces(f);
                if (this.mergeLines)
                    f = this.cleanerController.mergeDBLines(f);
                cleanedFiles.add(f);
            }
        } catch (Exception e) {
            throw new RNAFileException("Error caused by : " + tmp.getFileName());
        }
        return cleanedFiles;

    }*/



 /*   public void handleRun() {
        logger.info("RUN button clicked");
        var files = this.loadedRNAFiles;
        try {
            if (isTranslating) {
                files = this.clean(files);
                files = this.translate(files);
                this.saveFilesTo(files);
            } else {
                files = this.abstractions(files);
                this.saveFilesTo(files);
            }
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }*/

    /*private void loadFile(Path selectedRNAFile) throws RNAFileException {
        try {
            var rnaFile = this.ioController.loadFile(selectedRNAFile);
            this.loadedRNAFiles.add(rnaFile);
            // TODO: disable options/parameters depending on the format
            //this.chbxMergeLines.setDisable(this.ioController.getRecognizedFormat() != DB && this.ioController.getRecognizedFormat() != DB_NO_SEQUENCE);
            //this.abstractionsPane.setDisable(this.ioController.getRecognizedFormat() != DB && this.ioController.getRecognizedFormat() != DB_NO_SEQUENCE);
            //this.chbxGenerateNonCanonicalPairs.setDisable(this.ioController.getRecognizedFormat() != RNAML);
            // add event to select ButtonItem for destination format translation
            //this.initSelectEventOnButtonItems(this.translatorController.getAvailableTranslations(rnaFile.getFormat()));
        } catch (Exception e) {
            logger.severe("Could not load file: " + selectedRNAFile);
            throw new RNAFileException("Error caused by: " + selectedRNAFile);
        }
    }*/

    /*private void saveFilesTo(List<RNAFile> rnaFiles) throws IOException {
        if ((this.zipFileName != null) && (this.zipFileName.isEmpty() || this.zipFileName.isBlank())) {
            logger.severe("Insert a name for the zip file!");
            return;
        }
        logger.severe("Choose the directory where to save the files");
        if (this.outputDirectoryPath != null) {
            // zip options
            if (this.zipFileName != null) {
                String folderName = this.zipFileName;
                var zipPath = this.ioController.zipFiles(Path.of(this.outputDirectoryPath), folderName, rnaFiles, this.generateNonCanonicalPairs);
                logger.info(rnaFiles.size() + " files saved in: " + zipPath);
            } else { // files options
                this.ioController.saveFilesTo(rnaFiles, Path.of(this.outputDirectoryPath), this.generateNonCanonicalPairs);
                logger.info(" files saved in: " + this.outputDirectoryPath);
            }
        } else
            logger.info("no files saved");
    }

    public List<RNAFile> abstractions(List<RNAFile> files) {
        logger.info("Computing abstractions");
        var abstractions = new ArrayList<RNAFile>();
        for (var f : files) {
            if (this.generateCore)
                abstractions.add(this.abstractionsController.getCore(f));
            if (this.generateCorePlus)
                abstractions.add(this.abstractionsController.getCorePlus(f));
            if (this.generateShape)
                abstractions.add(this.abstractionsController.getShape(f));
        }
        return abstractions;
    }*/


    private boolean clean() {
        //if(this.removeComments || this.removeEmptyLines || this.stringToBeRemoved != null || this.mergeLines
        return false;
    }

    public String getInputPath() {
        return this.inputPath;
    }

    public String getOutputDirectoryPath() {
        return this.outputDirectoryPath;
    }

    public String getZipFileName() {
        return this.zipFileName;
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
