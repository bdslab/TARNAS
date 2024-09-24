package it.unicam.cs.bdslab.rnamlparsertool.service.loader;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import it.unicam.cs.bdslab.rnamlparsertool.abstraction.RnaDataLoader;
import it.unicam.cs.bdslab.rnamlparsertool.model.RnaMolecule;

/**
 * classe astratta con metodi adeguati per operare su un file
 * di testo e ottenere dati informativi sul file
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public abstract class TextDataLoader implements RnaDataLoader {

    /**
     * metodo per ottenre tutte le linee dato un nome di un file
     * @param path nome del file
     * @return lista di linee
     */
    protected List<List<String>> getLines(String path){
        try{
            return Files.readAllLines(Paths.get(path)).stream()
                .map( l ->  Arrays.asList((l.trim().split("\\s+"))))
                .toList();
        } catch (Exception e){
            return null;
        }
    }

    /**
     * metodo per impostare su un dato i dettagli opzionali che possono essere presenti
     * @param file
     * @param lines
     */
    protected void setFileInfo(RnaMolecule file, List<List<String>> lines) {
        boolean findOrganism = true, findNumber = true, findLink = true;
        for(List<String> line : lines) {
            if(line.size() > 1) {
                if(findOrganism && containAtIndex(line, 0,"organism")) {
                    file.setOrganism(getWordsFrom(line, 1));
                    findOrganism = false;
                } else if(findNumber && containAtIndex(line, 0,"accession") && containAtIndex(line, 1,"number")) {
                    file.setAccessionNumber(getWordsFrom(line, 2));
                    findNumber = false;
                } else if(findLink) {
                    String url = findFirstUrl(line);
                    if(url != null){
                        file.setReferenceLink(url);
                        findLink = false;
                    }
                }
            }
        }
    }

    /**
     * Metodo per ottenere le parole separate da spazi a partire da un dato indice
     * @param line linea di testo
     * @param from indice
     * @return parole
     */
    private String getWordsFrom(List<String> line, int from) {
        String s = "";
        for(int i = from; i < line.size(); i++) {
            s += (i != 1 ? " " : "") + line.get(i);
        }
        return s;
    }
    
    private boolean containAtIndex(List<String> line, int index, String word) {
        return line.get(index).toLowerCase().contains(word.toLowerCase());
    }

    private String findFirstUrl(List<String> line) {
        for(String word : line) {
            if(word.contains("http://") || word.contains("https://")) {
                return word;
            }
        }
        return null;
    }

}
