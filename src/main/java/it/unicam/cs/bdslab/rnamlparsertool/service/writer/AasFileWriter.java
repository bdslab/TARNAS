package it.unicam.cs.bdslab.rnamlparsertool.service.writer;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map.Entry;

import it.unicam.cs.bdslab.rnamlparsertool.model.RnaMolecule;
import it.unicam.cs.bdslab.rnamlparsertool.model.RnaChain;

/**
 * Classe per salvare dei dati nel formato AAS
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public final class AasFileWriter extends TextFileWriter {
	
	@Override
	public boolean writeAndSave(RnaMolecule chains, String path) {
		setFileInfo(chains);
		data += chains.getchains().stream().map(x -> x.getSequence()).reduce("", (a,b) -> a + b) + "\n";
		chains.getchains().stream().forEach( m -> writechain(m));
		return save(path);
	}

	/**
	 * Scrive i dati contenuti nella catena in formato AAS
	 * @param m catena da scrivere
	 */
	private void writechain(RnaChain m) {
		List<Entry<Integer, Integer>> list = m.getPairMap().entrySet().stream()
											.map(x -> x.getKey() < x.getValue() ? x : new SimpleEntry<Integer, Integer>(x.getValue(), x.getKey()))
											.distinct().toList();
		for (int i = 0; i < list.size()-1; i++) {
			data += "(" + list.get(i).getKey() + "," + list.get(i).getValue() +");";
		}

		data += "(" + list.get(list.size()-1).getKey() + "," + list.get(list.size()-1).getValue() +")";

	}
	

}
