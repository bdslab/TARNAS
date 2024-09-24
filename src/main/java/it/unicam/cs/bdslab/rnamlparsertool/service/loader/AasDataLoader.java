package it.unicam.cs.bdslab.rnamlparsertool.service.loader;

import java.util.Arrays;
import java.util.List;

import it.unicam.cs.bdslab.rnamlparsertool.exception.RnaParsingException;
import it.unicam.cs.bdslab.rnamlparsertool.model.RnaMolecule;
import it.unicam.cs.bdslab.rnamlparsertool.model.RnaChain;

/**
 * classe per caricare i dati contenuti in un file aas
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public final class AasDataLoader extends LineDataLoader {
    
    /**
     * Dati salvati da caricare
     */
    private RnaMolecule data;

    /**
     * metodo per ottenere i dati dal nome del file
     */
    @Override
    public RnaMolecule getData(String path) {
        this.data = new RnaMolecule();
		List<List<String>> lines = getLines(path);
        if(lines == null || lines.isEmpty())
            return null;
        setFileInfo(data, lines);
        List<Integer> starts = getSequencePositions(lines);
        if(starts.isEmpty())
            return null;
        for(int i = 0; i < starts.size(); i++) {
            String sequence = lines.get(starts.get(i)).get(0);
            String pairs = lines.size() > starts.get(i) + 1 && lines.get(starts.get(i) + 1).size() == 1 ? 
                           lines.get(starts.get(i) + 1).get(0) : "";
            RnaChain chain = getchain(i + 1, sequence, pairs);
            if(chain == null) {
                return null;
            }
            data.addchain(chain);
        }
        try {
			data.checkSecondaryStructure();
			return data;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    /**
     * metodo per ottenere una catena data una sequenza,
     * un indice e le coppie
     * @param index numero della catena
     * @param sequence sequenza della catena
     * @param pairs coppie della catena
     * @return catena
     */
    private RnaChain getchain(int index, String sequence, String pairs) {
        try {
            RnaChain chain = new RnaChain(index);
            for(char letter : sequence.toCharArray()) {
                chain.addRibonucleotide(letter);
            }
            if(!(pairs == null || pairs.equals(""))) {
                for(String pair : pairs.split(";")) {
                    if(pair.length() > 4) {
                        List<Integer> positions = Arrays.asList(pair.replace("(", "")
                                                    .replace(")", "").split(","))
                                                    .stream().map(s -> Integer.parseInt(s)).toList();
                        chain.addPair(positions.get(0), positions.get(1));
                    }
                }
            }
            return chain;
        } catch (RnaParsingException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
