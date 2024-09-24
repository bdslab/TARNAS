package it.unicam.cs.bdslab.rnamlparsertool.exception;

/**
 * eccezione per segnalare la posizione dell'errore di parsing
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public class RnaParsingException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * costruttore nel caso l'errore coinvolga un ribonucleide
	 * @param chain
	 * @param ribonucleotide
	 */
	public RnaParsingException(int chain, int ribonucleotide) {
        super("Error in chain n." + chain 
        		+ " and ribonucleotide in pos." + ribonucleotide);
    }
	
	/**
	 * ccostruttore nel caso l'eccezione coinvolga due ribonucleidi
	 * @param chain
	 * @param ribonucleotide1
	 * @param ribonucleotide2
	 */
	public RnaParsingException(int chain, int ribonucleotide1, int ribonucleotide2) {
        super("Error in chain n." + chain 
		+ ", ribonucleotide in pos." + ribonucleotide1
		+ " and ribonucleotide in pos." + ribonucleotide2);
    }

}
