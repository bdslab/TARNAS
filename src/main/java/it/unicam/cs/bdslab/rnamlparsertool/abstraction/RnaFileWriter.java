package it.unicam.cs.bdslab.rnamlparsertool.abstraction;

import it.unicam.cs.bdslab.rnamlparsertool.model.RnaMolecule;

/**
 * classe con la responsabilità di salvare dei dati 
 * su un dato file, da creare o sovrascrivere
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public interface RnaFileWriter {
	
	/**
	 * Metodo per la scrittura di un nuovo file contenente le informazioni
	 * @param chains infomrazioni da scrivere
	 * @param path file in cui scriverle
	 * @return true se la scrittura del file è andata a buon fine, false, altrimenti
	 */
	public boolean writeAndSave(RnaMolecule chains, String path);
	
}
