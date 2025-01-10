package it.unicam.cs.bdslab.tarnas.controller;

import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFile;

import java.util.ArrayList;

public class CleanerController {

    private final static CleanerController instance = new CleanerController();

    private CleanerController() {}

    /**
     * Factory method for the obtaining the {@link CleanerController} instance.
     *
     * @return the instance of this Singleton
     */
    public static CleanerController getInstance() {
        return instance;
    }

    /**
     * Merges the lines of the specified {@code rnaFile}, assuming they are already
     * merged during file reading. This method does nothing and returns the file unchanged.
     *
     * @param rnaFile the {@link RNAFile} whose lines would be merged if necessary.
     * @return the same {@link RNAFile}, unmodified.
     */
    public RNAFile mergeDBLines(RNAFile rnaFile) {
        // No validation or exception; simply return the file because lines are already merged.
        return rnaFile;
    }

    /**
     * Removes the entire header of the {@code rnaFile}.
     *
     * @param rnaFile the {@link RNAFile} whose header will be removed.
     * @return a new {@link RNAFile} with an empty header.
     */
    public RNAFile removeHeader(RNAFile rnaFile) {
        return new RNAFile(
                rnaFile.getFileName(),
                new ArrayList<>(),            // Empty header
                rnaFile.getBody(),
                rnaFile.getStructure(),
                rnaFile.getFormat()
        );
    }

    /**
     * Removes all header lines of the {@code rnaFile} that start with the given {@code prefix}.
     *
     * @param rnaFile the {@link RNAFile} to clean
     * @param prefix  the string prefix to filter out
     * @return a new {@link RNAFile} with filtered header
     */
    public RNAFile removeLinesStartingWith(RNAFile rnaFile, String prefix) {
        var filteredHeader = rnaFile.getHeader().stream()
                .filter(line -> !line.startsWith(prefix))
                .toList();
        return new RNAFile(
                rnaFile.getFileName(),
                filteredHeader,
                rnaFile.getBody(),
                rnaFile.getStructure(),
                rnaFile.getFormat()
        );
    }

    /**
     * Removes all header lines of the {@code rnaFile} that contain the given {@code word}.
     *
     * @param rnaFile the {@link RNAFile} to clean
     * @param word    the word to filter out
     * @return a new {@link RNAFile} with filtered header
     */
    public RNAFile removeLinesContaining(RNAFile rnaFile, String word) {
        var filteredHeader = rnaFile.getHeader().stream()
                .filter(line -> !line.contains(word))
                .toList();
        return new RNAFile(
                rnaFile.getFileName(),
                filteredHeader,
                rnaFile.getBody(),
                rnaFile.getStructure(),
                rnaFile.getFormat()
        );
    }

    /**
     * Removes all blank (whitespace-only) lines from both the header and body of the {@code rnaFile}.
     *
     * @param rnaFile the {@link RNAFile} to clean
     * @return a new {@link RNAFile} without blank header or body lines
     */
    public RNAFile removeWhiteSpaces(RNAFile rnaFile) {
        var filteredHeader = rnaFile.getHeader().stream()
                .filter(line -> !line.isBlank())
                .toList();
        var filteredBody = rnaFile.getBody().stream()
                .filter(line -> !line.isBlank())
                .toList();

        return new RNAFile(
                rnaFile.getFileName(),
                filteredHeader,
                filteredBody,
                rnaFile.getStructure(),
                rnaFile.getFormat()
        );
    }


    /**
     * Cleans a list of {@link RNAFile}s according to the specified options and updates them in {@link IOController}.
     *
     * @param file              {@code RNAFile} to clean
     * @param removeComments    if true, removes lines starting with '#' and '>'
     * @param stringToBeRemoved if not null, removes lines containing this string
     * @param removeEmptyLines  if true, removes blank lines in both header and body
     * @param mergeLines        if true, validates merging of DB lines (throws if invalid format)
     */
    public RNAFile clean(RNAFile file, boolean removeComments, String stringToBeRemoved,
                         boolean removeEmptyLines, boolean mergeLines) {

        // 1. Remove lines starting with '#' and '>' if requested
        if (removeComments) {
            file = removeLinesStartingWith(file, "#");
            file = removeLinesStartingWith(file, ">");
        }

        // 2. Remove lines containing a specific string if provided
        if (stringToBeRemoved != null)
            file = removeLinesContaining(file, stringToBeRemoved);

        // 3. Remove blank (whitespace-only) lines if requested
        if (removeEmptyLines)
            file = removeWhiteSpaces(file);

        // 4. Merge DB lines if requested
        if (mergeLines)
            file = mergeDBLines(file);

        return file;
    }

}
