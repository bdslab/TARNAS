package it.unicam.cs.bdslab.tarnas.model.cleaner;

import java.util.List;
import java.util.function.Function;

import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFile;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFormat;

/**
 * A representation of an RNA files cleaner.<br>
 * This class allows a cleaning function to be applied to any {@link RNAFile}.
 *
 * @author Piero Hierro, Piermichele Rosati
 * @see RNAFile
 * @see RNAFormat
 */
public class RNAFileCleaner {

    /**
     * Apply a cleaning function
     *
     * @param rnaFile the {@link RNAFile} on which to apply the function
     * @param function the function to be applied
     * @return the result of the function
     */
    public static RNAFile applyCleanOption(RNAFile rnaFile, Function<RNAFile, RNAFile> function) {
        return function.apply(rnaFile);
    }

}
