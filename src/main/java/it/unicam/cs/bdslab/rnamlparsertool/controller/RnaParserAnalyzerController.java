package it.unicam.cs.bdslab.rnamlparsertool.controller;

import it.unicam.cs.bdslab.rnamlparsertool.abstraction.RnaDataLoader;
import it.unicam.cs.bdslab.rnamlparsertool.model.OperationResult;
import it.unicam.cs.bdslab.rnamlparsertool.model.RnaMolecule;
import it.unicam.cs.bdslab.rnamlparsertool.service.comparator.RnaComparator;
import it.unicam.cs.bdslab.rnamlparsertool.utility.RnaHandlerBuilder;

/**
 * Controller che estende per parser con un check alla scrittura che segnala
 * una perdita di dati per conversione e una nuova funzione di confronto che
 * verifica la corrispondenza o le differenze della struttura primaria e
 * secondaria dati due file rna
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public class RnaParserAnalyzerController extends RnaParserController {
    /**
	 * servizio per la comparazione di due dati di rna
	 */
	private RnaComparator comparator;

    public RnaParserAnalyzerController() {
		super();
		comparator = new RnaComparator();
    }

    public RnaParserAnalyzerController(RnaHandlerBuilder builder) {
		super(builder);
		comparator = new RnaComparator();
    }

	/**
	 * Metodo per controllare se due file contengono la
	 * stessa struttura primaria e secondaria
	 * @param path1 percosto del primo file
	 * @param path2 percorso del secondo file
	 * @return esito dell'analisi
	 */
	public OperationResult equals(String path1, String path2) {
		path1 = checkExt(path1, false);
		path2= checkExt(path2, false);
		RnaDataLoader loader = getBuilder().buildDataLoader(path1);
		RnaMolecule data1 = loader.getData(path1);
		loader = getBuilder().buildDataLoader(path2);
		RnaMolecule data2 = loader.getData(path2);
		return this.comparator.areEquals(data1, data2);
	}

    @Override
    public synchronized OperationResult SaveLoadedData(String path) {
		return super.SaveLoadedData(path);
    }
    
    
}
