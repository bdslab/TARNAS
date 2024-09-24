package it.unicam.cs.bdslab.rnamlparsertool;



import java.io.File;
import java.util.Arrays;

import it.unicam.cs.bdslab.rnamlparsertool.controller.RnaParserAnalyzerController;
import it.unicam.cs.bdslab.rnamlparsertool.model.OperationResult;

/**
 * Classe di avvio del programma. 
 * Pensata per un utilizzo da terminale.
 * Se si vuole usare questo tool come una libreria esterna, cancellare questa classe
 * e interagire direttamente con il controller che più si adatta alle esigenze dello
 * sviluppatore interessato.
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public class RNAMLParserToolApp {

	/**
	 * Info da stampare su schermo quando gli argomenti non sono forniti
	 */
	private static String info = "To use this tool you must first type the name of the input file"
	+ " and then all the output files you want to produce. The formats supported by this tool are"
	+ " aas, ct, bpseq, db and rnaml.\n\nIf instead you want to compare two files to verify that they"
	+ " contain the same primary and secondary structure, you need to type \"equals file1 file2\"."
	+ "\n\nLastly, there is a multiple parsing function."
	+ "\nThe commands are \"all path/to/the/folder ext-in ext-out\" (Example: all . ct rnaml)";
	
	/**
	 * Metodo main per l'utilizzo via console
	 * @param args ci sono tre casi di utilizzo previsti: o il primo argomento è
	 * equals e il secondo e terzo sono i due file da confrontare, oppure il primo
	 * argomento è il file da leggere e tutti i seguenti sono quelli da scrivere,
	 * oppure il primo comando è all, il secondo il path della cartella e gli ultimi
	 * due sono le estensioni di input e output
	 */
	public static void main(String[] args) {
		if(args.length < 2){
			System.out.println(info);
		}else if(args[0].equals("equals") && args.length == 3) {
			compare(args[1], args[2]);
		} else if(args[0].equals("all") && args.length == 4) {
			parseAll(args[1], args[2], args[3]);
		} else {
			parse(args);
		}
	}

	private static void parse(String[] fileNames){
		RnaParserAnalyzerController controller = new RnaParserAnalyzerController();
		OperationResult result = controller.loadRna(fileNames[0]);
		result.getInfo().forEach(x -> System.out.println(x));
		if(result.result){
			for(int i = 1; i < fileNames.length; i++){
				result = controller.SaveLoadedData(fileNames[i]);
				result.getInfo().forEach(x -> System.out.println(x));
			}
		}
	}

	private static void compare(String name1, String name2){
		RnaParserAnalyzerController controller = new RnaParserAnalyzerController();
		OperationResult result = controller.equals(name1, name2);
		result.getInfo().forEach(x -> System.out.println(x));
	}

	private static void parseAll(String path, String extIn, String extOut) {
		for (File file : new File(path).listFiles()) {
			if (file.isFile() && file.getName().endsWith(extIn)) {
				String in = file.getName();
				String out = changeExtTo(in, extOut);
				parse(new String[]{in, out});
			}
		}
	}

	private static String changeExtTo(String base, String newExt){
		String[] parts = base.split("\\.");
		parts[parts.length - 1] = newExt;
		return Arrays.asList(parts).stream()
			.reduce("", (a, b) -> a + ( a.equals("") ? "" : ".") + b);
	}
	
}
