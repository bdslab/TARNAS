package it.unicam.cs.bdslab.rnamlparsertool.utility;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import it.unicam.cs.bdslab.rnamlparsertool.model.DbPair;
import it.unicam.cs.bdslab.rnamlparsertool.model.RnaMolecule;

/**
 * Classe per generare sequenze DB
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public class DotBracketSequenceGenerator extends DotBracketTranslator {
    /**
     * Dati finali da scrivere
     */
    private int [] array;

    /**
     * Metodo per ricavare una sequenza da una catena
     * @param chain catena da analizzare
     * @return la sequenza della catena
     */
    public String writeSequence(RnaMolecule chain) {
        if(chain != null){
            this.array = new int[chain.getLength()];
            analyze(chain);
        }
        String data = "";
        for(int i : array) {
            data += getDbBracket(i);
        }
		return data;
	}

    /**
     * Metodo per analizzare una catena
     * @param chain catena da analizzare
     */
    private void analyze(RnaMolecule chain) {
		List<DbPair> pairs = chain.getchains().stream().flatMap(x -> x.getPairMap().entrySet().stream())
											.map(x -> x.getKey() < x.getValue() ? x : 
											new SimpleEntry<Integer, Integer>(x.getValue(), x.getKey()))
											.distinct().map(x -> new DbPair(x.getKey(), x.getValue()))
                                            .toList();
        pairs = sortPairsByStartPoint(pairs);
        setPairsOrder(pairs);
        encodeBasePairs(pairs);
    }

    /**
     * metodo per ordinare le coppie
     * @param pairs coppie da ordinare
     * @return coppie ordinate
     */
    private List<DbPair> sortPairsByStartPoint(List<DbPair> pairs) {
        List<DbPair> tmp = new ArrayList<>(pairs);
        tmp.sort(Comparator.comparingInt(r -> r.getLeft()));
        return tmp;
    }

     /**
     * metodo per impostare l'ordine finale delle parentesi
     * @param pairs lista di pairs da impostare
     */
	private void setPairsOrder(List<DbPair> pairs) {
        if (pairs.size() < 2) return;
        pairs.get(0).setOrder(0);
        for (int i = 1; i < pairs.size(); i++) {
            int globalOrder = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (pairs.get(j).getOrder() == globalOrder && arePairsConflicting(pairs.get(i), pairs.get(j))){
                    globalOrder += 1;
                    j = 0;
                }
            }
            pairs.get(i).setOrder(globalOrder);
        }
    }

    /**
     * Metodo di servizio per verificare se due scoppie sono in conflitto
     * @param p1 coppia 1
     * @param p2 coppia 2
     * @return true se c'è conflitto, false altrimenti
     */
    private boolean arePairsConflicting(DbPair p1, DbPair p2) {
        boolean firstCase = p1.getLeft() < p2.getLeft() && p1.getRight() > p2.getLeft() && p2.getRight() > p1.getRight();
        boolean secondCase = p2.getLeft() < p1.getLeft() && p2.getRight() > p1.getLeft() && p1.getRight() > p2.getRight();
        return firstCase || secondCase;
    }

    /**
     * Metodo per codificare i valori delle coppie nell'array
     * @param pairs coppie da codificare
     */
    private void encodeBasePairs(List<DbPair> pairs) {
        for (DbPair p : pairs) {
            array[p.getLeft() - 1] = 1 + (p.getOrder()*2);
            array[p.getRight() - 1] = 2 + (p.getOrder()*2);
        }   
    }

}
