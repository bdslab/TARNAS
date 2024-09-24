package it.unicam.cs.bdslab.rnamlparsertool.model;

/**
 * classe che rappresenza un ribonucleide
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public class RnaRibonucleotide {
	
	private int chainId;
	private int position;
	private RnaBase base;

	public RnaRibonucleotide(int chainId, int position, RnaBase base) {
		this.chainId = chainId;
		this.position = position;
		this.base = base;
	}

	public int getchainId() {
		return chainId;
	}
	
	public int getPosition() {
		return position;
	}

	public RnaBase getBase() {
		return base;
	}
	

	@Override
	public String toString() {
		return RnaBase.getBaseLetter(base) + "";
	}
	
}
