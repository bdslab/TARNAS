package it.unicam.cs.bdslab.tarnas.model.utils;

import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFile;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFormat;
import it.unicam.cs.bdslab.tarnas.model.rnastructure.WeakBond;

import java.util.function.Predicate;

/**
 * This class is responsible for calculating statistics of an RNA file.
 */
public class RNAStatisticsCalculator {

    /**
     * Returns the number of nucleotides in the RNA file.
     *
     * @param rnaFile the RNA file
     * @return the number of nucleotides in the RNA file
     */
    public static int getNucleotideCount(RNAFile rnaFile) {
        if (rnaFile.getFormat().equals(RNAFormat.RNAML))
            return 0;
        return rnaFile.getStructure().getSize();
    }

    /**
     * Returns the number of bonds in the RNA file.
     *
     * @param rnaFile the RNA file
     * @return the number of bonds in the RNA file
     */
    public static int getBondCount(RNAFile rnaFile) {
        if (rnaFile.getFormat().equals(RNAFormat.RNAML))
            return 0;
        return rnaFile.getStructure().getBonds().size();
    }

    /**
     * Returns the number of GC bonds in the RNA file.
     *
     * @param rnaFile the RNA file
     * @return the number of GC bonds in the RNA file
     */
    public static int getGcBonds(RNAFile rnaFile) {
        return getBondsOf(bond -> isBondBetween('G', 'C', bond, rnaFile), rnaFile);
    }

    /**
     * Returns the number of AU bonds in the RNA file.
     *
     * @param rnaFile the RNA file
     * @return the number of AU bonds in the RNA file
     */
    public static int getAuBonds(RNAFile rnaFile) {
        return getBondsOf(bond -> isBondBetween('A', 'U', bond, rnaFile), rnaFile);
    }

    /**
     * Returns the number of GU bonds in the RNA file.
     *
     * @param rnaFile the RNA file
     * @return the number of GU bonds in the RNA file
     */
    public static int getGuBonds(RNAFile rnaFile) {
        return getBondsOf(bond -> isBondBetween('G', 'U', bond, rnaFile), rnaFile);
    }

    /**
     * Returns the number of A nucleotides in the RNA file.
     *
     * @param rnaFile the RNA file
     * @return the number of A nucleotides in the RNA file
     */
    public static int getACount(RNAFile rnaFile) {
        return getNucleotideCount(nucleotide -> nucleotide == 'A', rnaFile);
    }

    /**
     * Returns the number of C nucleotides in the RNA file.
     *
     * @param rnaFile the RNA file
     * @return the number of C nucleotides in the RNA file
     */
    public static int getCCount(RNAFile rnaFile) {
        return getNucleotideCount(nucleotide -> nucleotide == 'C', rnaFile);
    }

    /**
     * Returns the number of G nucleotides in the RNA file.
     *
     * @param rnaFile the RNA file
     * @return the number of G nucleotides in the RNA file
     */
    public static int getGCount(RNAFile rnaFile) {
        return getNucleotideCount(nucleotide -> nucleotide == 'G', rnaFile);
    }

    /**
     * Returns the number of U nucleotides in the RNA file.
     *
     * @param rnaFile the RNA file
     * @return the number of U nucleotides in the RNA file
     */
    public static int getUCount(RNAFile rnaFile) {
        return getNucleotideCount(nucleotide -> nucleotide == 'U', rnaFile);
    }

    /**
     * Returns the number of non-canonical pairs in the RNA file.
     *
     * @param format the RNA file format
     * @return the number of non-canonical pairs in the RNA file
     */
    private static boolean checkSequence(RNAFormat format) {
        return !(format.equals(RNAFormat.RNAML) || format.equals(RNAFormat.DB_NO_SEQUENCE) || format.equals(RNAFormat.AAS_NO_SEQUENCE) || format.equals(RNAFormat.FASTA));
    }

    /**
     * Returns the number of bonds that satisfy the given predicate.
     *
     * @param bondPredicate the bond predicate
     * @param rnaFile       the RNA file
     * @return the number of bonds that satisfy the given predicate
     */
    private static int getBondsOf(Predicate<WeakBond> bondPredicate, RNAFile rnaFile) {
        int bonds = 0;
        if (checkSequence(rnaFile.getFormat())) {
            for (WeakBond bond : rnaFile.getStructure().getBonds())
                if (bondPredicate.test(bond))
                    bonds++;
        }
        return bonds;
    }

    /**
     * Returns the number of nucleotides that satisfy the given predicate.
     *
     * @param nucleotidePredicate the nucleotide predicate
     * @param rnaFile             the RNA file
     * @return the number of nucleotides that satisfy the given predicate
     */
    private static int getNucleotideCount(Predicate<Character> nucleotidePredicate, RNAFile rnaFile) {
        int nucleotides = 0;
        if (checkSequence(rnaFile.getFormat())) {
            for (char nucleotide : rnaFile.getStructure().getSequence().toCharArray())
                if (nucleotidePredicate.test(nucleotide))
                    nucleotides++;
        }
        return nucleotides;
    }

    /**
     * Returns whether there is a bond between the given nucleotides.
     *
     * @param nucleotide1 the first nucleotide
     * @param nucleotide2 the second nucleotide
     * @param bond        the bond
     * @param rnaFile     the RNA file
     * @return whether there is a bond between the given nucleotides
     */
    private static boolean isBondBetween(char nucleotide1, char nucleotide2, WeakBond bond, RNAFile rnaFile) {
        var sequence = rnaFile.getStructure().getSequence();
        return (sequence.charAt(bond.getLeft() - 1) == nucleotide1 && sequence.charAt(bond.getRight() - 1) == nucleotide2) ||
                (sequence.charAt(bond.getLeft() - 1) == nucleotide2 && sequence.charAt(bond.getRight() - 1) == nucleotide1);
    }

    /**
     * Returns the number of non-canonical pairs in the RNA file.
     *
     * @param rnaFile the RNA file
     * @return the number of non-canonical pairs in the RNA file
     */
    public static int getNonCanonicalPairs(RNAFile rnaFile) {
        return getBondsOf(bond -> !isBondBetween('G', 'C', bond, rnaFile) &&
                !isBondBetween('A', 'U', bond, rnaFile) &&
                !isBondBetween('G', 'U', bond, rnaFile), rnaFile);
    }

}