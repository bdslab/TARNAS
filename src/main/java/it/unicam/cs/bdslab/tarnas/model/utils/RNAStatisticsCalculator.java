package it.unicam.cs.bdslab.tarnas.model.utils;

import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFile;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFormat;
import it.unicam.cs.bdslab.tarnas.model.rnastructure.WeakBond;

import java.util.function.Predicate;

/**
 * TODO: change statistics
 */
public class RNAStatisticsCalculator {

    public static int getNucleotideCount(RNAFile rnaFile) {
        if (rnaFile.getFormat().equals(RNAFormat.RNAML))
            return 0;
        return rnaFile.getStructure().getSize();
    }

    public static int getBondCount(RNAFile rnaFile) {
        if (rnaFile.getFormat().equals(RNAFormat.RNAML))
            return 0;
        return rnaFile.getStructure().getBonds().size();
    }

    public static int getGcBonds(RNAFile rnaFile) {
        return getBondsOf(bond -> isBondBetween('G', 'C', bond, rnaFile), rnaFile);
    }

    public static int getAuBonds(RNAFile rnaFile) {
        return getBondsOf(bond -> isBondBetween('A', 'U', bond, rnaFile), rnaFile);
    }

    public static int getGuBonds(RNAFile rnaFile) {
        return getBondsOf(bond -> isBondBetween('G', 'U', bond, rnaFile), rnaFile);
    }

    private static boolean checkSequence(RNAFormat format) {
        return !(format.equals(RNAFormat.RNAML) || format.equals(RNAFormat.DB_NO_SEQUENCE) || format.equals(RNAFormat.AAS_NO_SEQUENCE) || format.equals(RNAFormat.FASTA));
    }

    private static int getBondsOf(Predicate<WeakBond> bondPredicate, RNAFile rnaFile) {
        int bonds = 0;
        if (checkSequence(rnaFile.getFormat())) {
            var rnaStructure = rnaFile.getStructure();
            for (WeakBond bond : rnaFile.getStructure().getBonds())
                if (bondPredicate.test(bond))
                    bonds++;
        }
        return bonds;
    }

    private static boolean isBondBetween(char nucleotide1, char nucleotide2, WeakBond bond, RNAFile rnaFile) {
        var sequence = rnaFile.getStructure().getSequence();
        return (sequence.charAt(bond.getLeft() - 1) == nucleotide1 && sequence.charAt(bond.getRight() - 1) == nucleotide2) ||
                (sequence.charAt(bond.getLeft() - 1) == nucleotide2 && sequence.charAt(bond.getRight() - 1) == nucleotide1);
    }

    public static int getNonCanonicalPairs(RNAFile rnaFile) {
        return getBondsOf(bond -> isBondBetween('A', 'A', bond, rnaFile), rnaFile) +
                getBondsOf(bond -> isBondBetween('U', 'U', bond, rnaFile), rnaFile) +
                getBondsOf(bond -> isBondBetween('G', 'G', bond, rnaFile), rnaFile) +
                getBondsOf(bond -> isBondBetween('C', 'C', bond, rnaFile), rnaFile);
    }

}