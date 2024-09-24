package it.unicam.cs.bdslab.rnamlparsertool.utility;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

/**
 * Classe utile ad analizzare una sequenza DB
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public class DotBracketSequenceAnalyzator extends DotBracketTranslator {
    
    /**
     * Meotod per analizzare una sequenza DB
     * @param data sequenza da analizzare
     * @return lista di di coppie espresse in array bidimensionali
     */
    public List<Integer[]> getPairs(String data) {
        List<Integer[]> pairs = new ArrayList<>();
        int[] symbols = data.chars().map(c -> getDbNumber((char)c)).toArray();
        int max = 0;
        for(int symbol: symbols) {
            if(symbol > max)
                max = symbol;
        }
        if(max % 2 == 1)
            return null;
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i < max; i += 2) {
            for(int j = 0; j < symbols.length; j++) {
                if(symbols[j] == i) {
                    stack.push(j);
                } else if (symbols[j] == i + 1) {
                    int p = stack.pop();
                    pairs.add(new Integer []{p + 1, j + 1});
                }
            }
            if(stack.size() != 0) {
                return null;
            }
        }
        return pairs;
    }

}