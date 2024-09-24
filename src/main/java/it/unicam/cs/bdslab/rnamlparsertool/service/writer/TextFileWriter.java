package it.unicam.cs.bdslab.rnamlparsertool.service.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import it.unicam.cs.bdslab.rnamlparsertool.abstraction.RnaFileWriter;
import it.unicam.cs.bdslab.rnamlparsertool.model.RnaMolecule;

/**
 * Classe astratta con metodi di servizio utili
 * a scrivere nei formati simili a testo
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public abstract class TextFileWriter implements RnaFileWriter {
    
    protected String data = "";
    
    /**
     * Metodo per salvare i dati precedentemente inseriti
     * in un dato path, sovrascrivendo eventualmente precedenti
     * dati allo stessto path
     * @param path path di destinazione
     * @return true se l'opezione va a buon fine, false altrimenti
     */
	protected boolean save(String path) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, false));
            writer.write(data);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo per scrivere nei dati delle informazioni
     * opzionali dell'rna, se presenti
     * @param rnaData dato dell'rna
     */
    protected void setFileInfo(RnaMolecule rnaData) {
        if(rnaData.getOrganism() != null) {
            data += "# Organism: " + rnaData.getOrganism() + "\n";
        }
        if(rnaData.getAccessionNumber() != null) {
            data += "# Accession Number: " + rnaData.getAccessionNumber() + "\n";
        }
        if(rnaData.getReferenceLink() != null) {
            data += "# Citation and related information available at " + rnaData.getReferenceLink() + "\n";
        }
    }


}
