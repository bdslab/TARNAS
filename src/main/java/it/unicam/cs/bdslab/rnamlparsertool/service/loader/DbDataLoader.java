package it.unicam.cs.bdslab.rnamlparsertool.service.loader;

import java.util.List;

import it.unicam.cs.bdslab.rnamlparsertool.exception.RnaParsingException;
import it.unicam.cs.bdslab.rnamlparsertool.model.RnaMolecule;
import it.unicam.cs.bdslab.rnamlparsertool.model.RnaChain;
import it.unicam.cs.bdslab.rnamlparsertool.utility.DotBracketSequenceAnalyzator;

/**
 * classe per caricare i dati contenuti in un file DB
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public final class DbDataLoader extends LineDataLoader {

    private RnaMolecule data;
    /**
     * Analizzatore della struttura secondaria
     */
    private final DotBracketSequenceAnalyzator analyzator = new DotBracketSequenceAnalyzator();

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
            String pairs = lines.get(starts.get(i) + 1).get(0) ;
            RnaChain chain = getchain(i, sequence, pairs);
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
     * Metodo per ottenere una catena
     * @param index indice della catena
     * @param sequence sequenza primaria della catena
     * @param pairs sequenza secondaria della catena
     * @return catena se il parsing è andato a buon fine, null altrimenti
     */
    private RnaChain getchain(int index, String sequence, String pairs) {
        try {
            RnaChain chain = new RnaChain(index);
            for(char letter : sequence.toCharArray()) {
                chain.addRibonucleotide(letter);
            }
            List<Integer[]> pairData = analyzator.getPairs(pairs);
            for(Integer[] pair : pairData) {
                chain.addPair(pair[0], pair[1]);
            }
            return chain;
        } catch (RnaParsingException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}