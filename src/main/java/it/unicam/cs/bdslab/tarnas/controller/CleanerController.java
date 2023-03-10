package it.unicam.cs.bdslab.tarnas.controller;

import it.unicam.cs.bdslab.tarnas.model.cleaner.RNAFileCleaner;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFile;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFileConstructor;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFileTranslator;
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
        var function = this.removeIf(rnaFile.getContent(), line -> !line.isBlank());
        return RNAFileCleaner.applyCleanOption(rnaFile, function);
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
            var newHeader = new ArrayList<String>();
            for (var line : header)
                if (!predicate.test(line))
                    newHeader.add(line);
            return new RNAFile(rnaFile.getFileName(), newHeader, rnaFile.getBody(), rnaFile.getStructure(), rnaFile.getFormat());
        };
    }

    private Function<RNAFile, RNAFile> mergeDBLines() {
        // the file is already read with the line merged, here it is only checked whether the format is DB or DB NO SEQUENCE
        return rnaFile -> {
            if (rnaFile.getFormat() != RNAFormat.DB && rnaFile.getFormat() != RNAFormat.DB_NO_SEQUENCE)
                throw new IllegalArgumentException("Cannot merge lines of " + rnaFile.getFormat() + " format");
            return rnaFile;
        };
    }

}
