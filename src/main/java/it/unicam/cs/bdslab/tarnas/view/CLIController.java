package it.unicam.cs.bdslab.tarnas.view;

import it.unicam.cs.bdslab.tarnas.controller.AbstractionsController;
import it.unicam.cs.bdslab.tarnas.controller.CleanerController;
import it.unicam.cs.bdslab.tarnas.controller.IOController;
import it.unicam.cs.bdslab.tarnas.controller.TranslatorController;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFile;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFileException;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFormat;

import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Logger;


@Command(
        name = "tarnas",
        mixinStandardHelpOptions = true, version = "tarnas 1.0",
        description = "A simple CLI tool for RNA file format conversion."
)
public class CLIController implements Callable<Integer> {

    public static final Logger logger = Logger.getLogger("it.unicam.cs.bdslab.tarnas.view.CLIController");

    private final TranslatorController translatorController;

    private final IOController ioController;

    private final CleanerController cleanerController;

    private final AbstractionsController abstractionsController;

    // TODO: check the usage of this variable. IT could be useless...
    private RNAFormat selectedFormat;

    private final boolean isTranslating;


    // Input RNA file path or RNA directory path
    @Parameters(index = "0", description = "Input RNA file path or RNA directory path", arity = "1")
    private String inputPath;

    // Output RNA directory path
    /*@Parameters(index = "1", description = "Output directory path")
    private String outputDirectoryPath;

    // Cleaning options

    // remove all comments from the input file
    @Option(names = {"-c", "--rcomments"}, description = "Remove all comments from the input file")
    private boolean removeComments;


    // remove lines containing an input string from the input file
    @Option(names = {"-r", "--rlines"}, description = "Remove lines containing an input string from the input file")
    private String stringToBeRemoved;

    // remove all empty lines from the input file
    @Option(names = {"-e", "--empty"}, description = "Remove all empty lines from the input file")
    private boolean removeEmptyLines;

    // merge all lines in the input file only for DB and DB NO SEQUENCE formats
    @Option(names = {"-m", "--merge"}, description = "Merge all lines in the input file only for DB and DB NO SEQUENCE formats")
    private boolean mergeLines;

    // Translation options

    // include the header in the output file
    //@Option(names = {"-h", "--header"}, description = "Include the header in the output file")
    private boolean includeHeader;

    // generate non canonical pairs (only for RNAML input format)
    @Option(names = {"-n", "--non-canonical"}, description = "Generate non canonical pairs (only for RNAML input format)")
    private boolean generateNonCanonicalPairs;

    // translate to the specified destination format
    @Option(names = {"-t", "--translate"}, description = "Translate to the specified destination format")
    private String destinationFormat;

    // Save as zip file
    @Option(names = {"-z", "--zip"}, description = "Save as zip file")
    private String zipFileName;

    // Abstraction options

    // generate core
    @Option(names = {"-g", "--generate"}, description = "Generate core")
    private boolean generateCore;

    // generate coreplus
    @Option(names = {"-G", "--generate-plus"}, description = "Generate coreplus")
    private boolean generateCorePlus;

    // generate shape
    @Option(names = {"-s", "--shape"}, description = "Generate shape")
    private boolean generateShape;*/

    public CLIController() {
        logger.info("Initializing...");
        this.isTranslating = false;
        // init controllers
        this.cleanerController = CleanerController.getInstance();
        this.ioController = IOController.getInstance();
        this.translatorController = TranslatorController.getInstance();
        this.abstractionsController = AbstractionsController.getInstance();
        logger.info("Initialization done");
    }


    public boolean addFile(Path p) {
        if (!Files.exists(p)) return false;
        try {
            if (Files.isRegularFile(p)) {
                return loadPath(p, "file");
            }
            if (Files.isDirectory(p)) {
                return loadPath(p, "folder");
            }
        } catch (IOException e) {
            logger.severe(e.getMessage());
        }

        return false;
    }

    private boolean loadPath(Path p, String type) throws IOException {
        logger.info("Adding " + type);
        if (type.equals("file"))
            this.ioController.loadFile(p);
        else
            this.ioController.loadDirectory(p);
        logger.info(type + " added successfully");
        return true;
    }



    /*public void handleAddFile(Path inputFilePath) {
        logger.info("Adding file");
        if (inputFilePath != null) {
            try {
                this.loadFile(inputFilePath);
                logger.info("File added successfully");
            } catch (Exception e) {
                logger.severe(e.getMessage());
            }
        }
        logger.info("Exit add file");
    }*/

    /*public void handleAddFolder(Path inputFolderPath) {
        logger.info("Adding folder");
        if (inputFolderPath != null) {
            try {
                var files = Files.walk(inputFolderPath)
                        .filter(Files::isRegularFile)
                        .toList();
                for (var f : files)
                    this.loadFile(f);
                logger.info("Folder added successfully");
            } catch (Exception e) {
                logger.severe(e.getMessage());
            }
        }
        logger.info("Exit add file");
    }*/

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

    }

    private List<RNAFile> translate(List<RNAFile> files) throws RNAFileException {
        List<RNAFile> translatedRNAFiles;
        translatedRNAFiles = this.translatorController.translateAllLoadedFiles(files, this.selectedFormat);
        if (!this.includeHeader)
            translatedRNAFiles = translatedRNAFiles.parallelStream()
                    .map(f -> this.cleanerController.removeHeader(f))
                    .toList();
        return translatedRNAFiles;
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

    @Override
    public Integer call() {
        this.addFile(Path.of(this.inputPath));


        // TODO: implement the CLI controller

        // Check the options: the user must choose between cleaning and/or translating, or generating abstractions, not both!

        return 0;
    }
}