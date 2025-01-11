package it.unicam.cs.bdslab.tarnas.model.rnafile;

import it.unicam.cs.bdslab.tarnas.model.rnastructure.WeakBond;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Comparator;

/**
 * A comparator for comparing the bonds of two RNA files.
 */
public class BondsComparator {

    private static final RNAFileConstructor LISTENER = RNAFileConstructor.getInstance();

    public static void compare(Path p1, Path p2) throws IOException {
        var rnaFile1 = LISTENER.construct(p1);
        var rnaFile2 = LISTENER.construct(p2);

        var bondList1 = rnaFile1.getStructure().getBonds();
        var bondList2 = rnaFile2.getStructure().getBonds();

        // Sort bond lists by their left index
        bondList1.sort(Comparator.comparing(WeakBond::getLeft));
        bondList2.sort(Comparator.comparing(WeakBond::getLeft));

        // Compare each bond
        for (int i = 0; i < bondList1.size(); i++) {
            var b1 = bondList1.get(i);
            var b2 = bondList2.get(i);

            if (!b1.equals(b2)) {
                System.out.printf("Mismatch at index %d: %s vs %s%n", i, b1, b2);
                return;
            } else {
                System.out.printf("Match at index %d: %s%n", i, b1);
            }
        }

        System.out.println("Match OK");
    }

}
