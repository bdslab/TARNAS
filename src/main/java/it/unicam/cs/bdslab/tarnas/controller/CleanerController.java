package it.unicam.cs.bdslab.tarnas.controller;

import it.unicam.cs.bdslab.tarnas.model.cleaner.RNAFileCleaner;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFile;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CleanerController {

    private static CleanerController instance;

    private CleanerController() {
    }

    /**
     * Factory method for the obtaining the {@link CleanerController} instance.
     *
     * @return the instance of this Singleton
     */
    public static CleanerController getInstance() {
        if (instance == null)
            instance = new CleanerController();
        return instance;
    }

    /**
     * Merges the lines of the specified {@code rnaFile} with {@link RNAFormat#DB} or {@link RNAFormat#DB_NO_SEQUENCE} format.
     *
     * @param rnaFile the specified {@code RNAFile} to merge its lines.
     * @return an {@link RNAFile}
     * @throws IllegalArgumentException if the format is not {@link RNAFormat#DB} or {@link RNAFormat#DB_NO_SEQUENCE}
     */
    public RNAFile mergeDBLines(RNAFile rnaFile) {
        return RNAFileCleaner.applyCleanOption(rnaFile, this.mergeDBLines());
    }

    /**
     * Remove the header from the {@code rnaFile}
     *
     * @param rnaFile an {@link RNAFile} from which to remove the header.
     * @return an {@link RNAFile}
     */
    public RNAFile removeHeader(RNAFile rnaFile) {
        return new RNAFile(rnaFile.getFileName(), new ArrayList<>(), rnaFile.getBody(), rnaFile.getStructure(), rnaFile.getFormat());
    }

    /**
     * Removes all the header lines of the {@code rnaFile} that starts with the specified {@code prefix}.
     *
     * @param rnaFile the {@link RNAFile} from which removing any header lines
     * @param prefix  the prefix filter to remove any lines from the header of the {@code rnafile}
     * @return an {@link RNAFile}
     */
    public RNAFile removeLinesStartingWith(RNAFile rnaFile, String prefix) {
        var function = this.removeIf(rnaFile.getHeader(), line -> line.startsWith(prefix));
        return RNAFileCleaner.applyCleanOption(rnaFile, function);
    }

    /**
     * Removes all the header lines of the {@code rnafile} that contains the specified {@code word}.
     *
     * @param rnaFile the {@link RNAFile} from which removing any header lines
     * @param word    the word filter to remove any lines from the header of the {@code rnafile}
     * @return an {@link RNAFile}
     */
    public RNAFile removeLinesContaining(RNAFile rnaFile, String word) {
        var function = this.removeIf(rnaFile.getHeader(), line -> line.contains(word));
        return RNAFileCleaner.applyCleanOption(rnaFile, function);
    }

    /**
     * Removes all the blank lines of the {@code rnafile}.
     *
     * @param rnaFile the {@link RNAFile} from which removing any header lines
     * @return the new content, which has all the lines that are not blank
     */
    public RNAFile removeWhiteSpaces(RNAFile rnaFile) {
        var function = this.removeIf(rnaFile.getHeader(), rnaFile.getBody(), String::isBlank);
        return RNAFileCleaner.applyCleanOption(rnaFile, function);
    }

    public List<RNAFile> clean(List<RNAFile> files, boolean removeComments, String stringToBeRemoved, boolean removeEmptyLines,
                               boolean mergeLines) throws Exception {
        RNAFile tmp = null;
        var cleanedFiles = new ArrayList<RNAFile>();
        try {
            for (var f : files) {
                tmp = f;
                if (removeComments) {
                    f = this.removeLinesStartingWith(f, "#");
                    f = this.removeLinesStartingWith(f, ">");
                }
                if (stringToBeRemoved != null)
                    f = this.removeLinesContaining(f, stringToBeRemoved);
                if (removeEmptyLines)
                    f = this.removeWhiteSpaces(f);
                if (mergeLines)
                    f = this.mergeDBLines(f);
                cleanedFiles.add(f);
            }
        } catch (IllegalArgumentException e) {
            throw new Exception("Error caused by : " + tmp.getFileName() + "\n" + e.getMessage());
        } catch (Exception e) {
            throw new Exception("Error caused by : " + tmp.getFileName());
        }
        return cleanedFiles;
    }

    /**
     * Removes all the lines that satisfies the {@code predicate} from the {@code header}.
     *
     * @param header    the header from which remove all the lines satisfy the {@code predicate}.
     * @param predicate the {@link Predicate} to satisfy for header lines removal
     * @return a {@link Function} that represent the removing function.
     */
    private Function<RNAFile, RNAFile> removeIf(List<String> header, Predicate<String> predicate) {
        return rnaFile -> {
            var newHeader = this.filterList(header, predicate);
            return new RNAFile(rnaFile.getFileName(), newHeader, rnaFile.getBody(), rnaFile.getStructure(), rnaFile.getFormat());
        };
    }

    /**
     * Removes all the lines that satisfies the {@code predicate} from the {@code header} and {@code body}.
     * @param header the header from which remove all the lines satisfy the {@code predicate}.
     * @param body the body from which remove all the lines satisfy the {@code predicate}.
     * @param predicate the {@link Predicate} to satisfy for header and body lines removal
     * @return a {@link Function} that represent the removing function.
     */
    private Function<RNAFile, RNAFile> removeIf(List<String> header, List<String> body, Predicate<String> predicate) {
        return rnaFile -> {
            var newHeader = this.filterList(header, predicate);
            var newBody = this.filterList(body, predicate);
            return new RNAFile(rnaFile.getFileName(), newHeader, newBody, rnaFile.getStructure(), rnaFile.getFormat());
        };
    }

    /**
     * Filters the {@code list} with the specified {@code predicate}.
     * @param list the list to filter
     * @param predicate the {@link Predicate} to satisfy for list filtering
     * @return a new list that contains all the elements that do not satisfy the {@code predicate}
     */
    private List<String> filterList(List<String> list, Predicate<String> predicate) {
        return list.stream()
                .filter(line -> !predicate.test(line))
                .toList();
    }

    /**
     * Merges the lines of the {@code rnaFile} with {@link RNAFormat#DB} or {@link RNAFormat#DB_NO_SEQUENCE} format.
     * @return a {@link Function} that represent the merging function.
     */
    private Function<RNAFile, RNAFile> mergeDBLines() {
        // the file is already read with the line merged, here it is only checked whether the format is DB or DB NO SEQUENCE
        return rnaFile -> {
            if (rnaFile.getFormat() != RNAFormat.DB && rnaFile.getFormat() != RNAFormat.DB_NO_SEQUENCE)
                throw new IllegalArgumentException("Cannot merge lines of " + rnaFile.getFormat() + " format");
            return rnaFile;
        };
    }

}
