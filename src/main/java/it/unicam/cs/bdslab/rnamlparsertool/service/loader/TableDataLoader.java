package it.unicam.cs.bdslab.rnamlparsertool.service.loader;

import java.util.ArrayList;
import java.util.List;

import it.unicam.cs.bdslab.rnamlparsertool.model.RnaMolecule;
import it.unicam.cs.bdslab.rnamlparsertool.model.RnaChain;

/**
 * classe astratta per il caricamento di dati da un file con i valori
 * espressi in matrici. si implementa fornando durante la costruzione
 * valori adeguati per i parametri interi
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public abstract class TableDataLoader extends TextDataLoader {

    /**
     * Dati da caricare
     */
    private RnaMolecule data;
    /**
     * Indici da riempire con la concretizzazione della classe
     */
    protected int dimension, pairOnePosition,
                  pairTwoPosition, basePosition;

    @Override
    public RnaMolecule getData(String path) {
        this.data = new RnaMolecule();
		List<List<String>> lines = getLines(path);
        if(lines == null || lines.isEmpty())
            return null;
        setFileInfo(data, lines);
        List<Integer> starts = getStartLines(lines);
        if(starts.isEmpty())
            return null;
        for(int i = 0; i < starts.size(); i++) {
            int until = i + 1 == starts.size() ? lines.size() : starts.get(i + 1);
            List<List<String>> chainList = lines.subList(starts.get(i), until).stream()
                                                   .filter(l -> l.size() == dimension).toList();
            RnaChain chain = getchain(chainList, new RnaChain(i + 1));
            if(chain == null)
                return null; 
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
     * Metodo che prende le linee in cui la sequenza inizia
     * @param lines linee da controllare
     * @return lista di indici
     */
    private List<Integer> getStartLines(List<List<String>> lines){
        List<Integer> starts = new ArrayList<>();
        for(int i = 0; i < lines.size(); i++) {
            if(lines.get(i).get(0).equals("1")) {
                starts.add(i);
            }
        }
        return starts;
    }

    /**
     * metodo per scrivere su una catena dato un insieme di linee
     * @param lines linee in cui scrivere
     * @param chain catena in cui scrivere
     * @return la catena inserita, con tutti i nuovi dati, o null in caso di errore
     */
    private RnaChain getchain(List<List<String>> lines, RnaChain chain) {
        try {
            for(List<String> line : lines) {
                chain.addRibonucleotide(line.get(basePosition).charAt(0));
            }
            List<Integer> toSkip = new ArrayList<>();
            for(List<String> line : lines) {
                int pair1 = Integer.parseInt(line.get(pairOnePosition)),
                    pair2 = Integer.parseInt(line.get(pairTwoPosition));
                if(!(pair2 == 0 || toSkip.contains(pair1))) {
                    chain.addPair(pair1, pair2);
                    toSkip.add(pair2);
                }
            }
            return chain;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
