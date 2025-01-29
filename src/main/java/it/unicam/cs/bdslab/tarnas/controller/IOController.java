package it.unicam.cs.bdslab.tarnas.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFile;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFileConstructor;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFormat;

import static it.unicam.cs.bdslab.tarnas.model.utils.RNAStatisticsCalculator.*;

/**
 * Singleton controller for loading, saving, and packaging RNA files.
 * Exceptions are propagated upwards.
 */
public class IOController {

    private static final IOController instance = new IOController();
    private RNAFormat recognizedFormat;  // Tracks the format of loaded files
    private final List<RNAFile> loadedRNAFiles;

    private IOController() {
        this.loadedRNAFiles = new ArrayList<>();
    }

    public static IOController getInstance() {
        return instance;
    }

    /**
     * Returns an unmodifiable list of currently loaded RNA files.
     */
    public List<RNAFile> getLoadedRNAFiles() {
        return List.copyOf(loadedRNAFiles);
    }

    public RNAFormat getRecognizedFormat() {
        return recognizedFormat;
    }

    /**
     * Builds an {@link RNAFile} from the given path.
     */
    public RNAFile getRNAFileOf(Path srcFilePath) throws IOException {
        return RNAFileConstructor.getInstance().construct(srcFilePath);
    }

    /**
     * Loads a single RNA file and checks format consistency with any already-loaded files.
     */
    public RNAFile loadFile(Path srcFilePath) throws IOException {
        var rnaFile = getRNAFileOf(srcFilePath);

        if (recognizedFormat == null || recognizedFormat.equals(rnaFile.getFormat())) {
            loadedRNAFiles.add(rnaFile);
            recognizedFormat = rnaFile.getFormat();
        } else {
            throw new IllegalArgumentException(
                    "All loaded files must share the same format: " + recognizedFormat +
                            ", but got: " + rnaFile.getFormat()
            );
        }

        return rnaFile;
    }

    /**
     * Loads all regular files from a directory.
     */
    public void loadDirectory(Path srcDirectoryPath) throws IOException {
        try (var directoryStream = Files.newDirectoryStream(srcDirectoryPath)) {
            for (var path : directoryStream) {
                if (Files.isRegularFile(path)) {
                    loadFile(path);
                }
            }
        }
    }

    /**
     * Saves and optionally processes RNA files, generates statistics, and zips the result.
     */
    public void saveFiles(List<RNAFile> files,
                          Path dstPath,
                          boolean generateNonCanonicalPairs,
                          boolean generateStatistics,
                          String zipFileName) throws IOException {

        var generatedFiles = new ArrayList<Path>();

        saveRNAFiles(files, dstPath, generatedFiles);
        processNonCanonicalPairs(generateNonCanonicalPairs, dstPath, generatedFiles);
        generateStatistics(files, dstPath, generateStatistics, generatedFiles);
        createZipFile(dstPath, zipFileName, generatedFiles);
    }

    private void saveRNAFiles(List<RNAFile> files, Path dstPath, List<Path> generatedFiles) throws IOException {
        for (var file : files) {
            var extension = (file.getFormat() == RNAFormat.RNAML) ? ".xml" : ".txt";
            var fileName = file.getFileName() + extension;
            var destinationPath = dstPath.resolve(fileName);

            Files.write(destinationPath, file.getContent());
            generatedFiles.add(destinationPath);
        }
    }

    /**
     * If {@code generateNonCanonicalPairs} is true, updates *.csv files in the current dir.
     * Otherwise, deletes them.
     */
    private void processNonCanonicalPairs(boolean generateNonCanonicalPairs,
                                          Path dstPath,
                                          List<Path> generatedFiles) throws IOException {
        var currentDir = Paths.get(System.getProperty("user.dir"));
        try (var csvStream = Files.list(currentDir)) {
            var csvFiles = csvStream
                    .filter(path -> path.toString().endsWith(".csv"))
                    .toList();

            for (var csvFile : csvFiles) {
                if (generateNonCanonicalPairs) {
                    var newFileName = csvFile.getFileName().toString().replace(".csv", "_nc.csv");
                    var destinationPath = dstPath.resolve(newFileName);

                    Files.move(csvFile, destinationPath);

                    // Replace spaces with commas in each line
                    var updatedLines = Files.readAllLines(destinationPath).stream()
                            .map(line -> line.replace(" ", ","))
                            .collect(Collectors.toList());
                    Files.write(destinationPath, updatedLines);

                    generatedFiles.add(destinationPath);
                } else {
                    Files.delete(csvFile);
                }
            }
        }
    }

    private void generateStatistics(List<RNAFile> files,
                                    Path dstPath,
                                    boolean generateStatistics,
                                    List<Path> generatedFiles) throws IOException {
        if (!generateStatistics) return;

        for (var file : files) {
            var statsFileName = file.getFileName().split("\\.")[0] + "_seqInfo.csv";
            var statsFilePath = dstPath.resolve(statsFileName);

            var header = "Nucleotide count, Bond count, A count, C count, G count, U count, GC bonds, AU bonds, GU bonds";
            var statsData = String.join(", ",
                    String.valueOf(getNucleotideCount(file)),
                    String.valueOf(getBondCount(file)),
                    String.valueOf(getACount(file)),
                    String.valueOf(getCCount(file)),
                    String.valueOf(getGCount(file)),
                    String.valueOf(getUCount(file)),
                    String.valueOf(getGcBonds(file)),
                    String.valueOf(getAuBonds(file)),
                    String.valueOf(getGuBonds(file))
            );

            Files.write(statsFilePath, List.of(header, statsData));
            generatedFiles.add(statsFilePath);
        }
    }

    private void createZipFile(Path dstPath, String zipFileName, List<Path> generatedFiles) throws IOException {
        if (zipFileName == null || zipFileName.isBlank()) return;

        var zipFilePath = dstPath.resolve(zipFileName + ".zip");

        try (var zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFilePath))) {
            for (var filePath : generatedFiles) {
                var zipEntry = new ZipEntry(filePath.getFileName().toString());
                zipOutputStream.putNextEntry(zipEntry);

                Files.copy(filePath, zipOutputStream);
                zipOutputStream.closeEntry();

                Files.delete(filePath);  // Remove original file after adding to ZIP
            }
        }
    }

    public void deleteFile(RNAFile rnaFile) {
        loadedRNAFiles.remove(rnaFile);
        if (loadedRNAFiles.isEmpty()) {
            recognizedFormat = null;
        }
    }

    public void clearAllDataStructures() {
        loadedRNAFiles.clear();
        recognizedFormat = null;
    }
}
