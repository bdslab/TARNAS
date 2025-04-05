package it.unicam.cs.bdslab.rnamlparsertool.service.writer;

import java.util.Map;

import it.unicam.cs.bdslab.rnamlparsertool.model.RnaMolecule;
import it.unicam.cs.bdslab.rnamlparsertool.model.RnaChain;

/**
 * Classe per scrivere dati nel formato CT
 *
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public final class CtFileWriter extends TextFileWriter {

    private int count = 1;

    @Override
    public boolean writeAndSave(RnaMolecule chains, String path) {
        setFileInfo(chains);
        data += chains.getchains().stream().map(x -> x.getLength()).reduce(0, (a, b) -> a + b) + " Energy = 0\n";
        chains.getchains().stream().forEach(m -> writechain(m));
        return save(path);
    }

    /**
     * Scrive i dati di una catena nel formato CT
     *
     * @param m catena da scrivere
     */
    private void writechain(RnaChain m) {
        char[] array = m.getSequence().toCharArray();
        Map<Integer, Integer> pairs = m.getPairMap();
        for (int i = 1; i <= array.length; i++) {
            int pair = pairs.getOrDefault(i, -1);
            data += count + " " + array[i - 1] + " "
                    + (i - 1) + " " + (i + 1)
                    + " " + (pair == -1 ? "0" : pair) + " " + count++ + "\n";
        }
    }


}
