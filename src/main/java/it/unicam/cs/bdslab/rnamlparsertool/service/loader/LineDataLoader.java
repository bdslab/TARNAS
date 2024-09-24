package it.unicam.cs.bdslab.rnamlparsertool.service.loader;

import java.util.List;

import java.util.ArrayList;

/**
 * Classe astratta contenti metodi utili a caricatori di formati
 * di dati disposti a linea
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public abstract class LineDataLoader extends TextDataLoader {

    /**
     * Metodo per trovare tutti gli indici contenenti una sequenza
     * @param lines linee da controllare
     * @return indici con sequenze di ribonucleidi
     */
    protected List<Integer> getSequencePositions(List<List<String>> lines) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < lines.size(); i++) {
            if(lines.get(i).size() == 1 && isSequence(lines.get(i).get(0)))
                list.add(i);
        }
        return list;
    }

    /**
     * metodo per controllare se una data parola è una sequenza
     * @param word parola da controllare
     * @return true se è una sequenza, false altrimenti
     */
    private boolean isSequence(String word) {
        if(word == null || word.length() == 0)
            return false;
        word = word.toUpperCase();
        for(char letter : word.toCharArray()) {
            if(isNotSequenceLetter(letter))
                return false;
        }
        return true;
    }

    /**
     * Metodo per verificare se un carattere
     * può far parte di una sequenza
     * @param letter carattere da controllare
     * @return true se è invalido, false altrimenti
     */
    private boolean isNotSequenceLetter(char letter) {
        String l = ("" + letter).toUpperCase();
        return !"ACUGNWRMYKSBVDH".contains(l);
    }

    
}
