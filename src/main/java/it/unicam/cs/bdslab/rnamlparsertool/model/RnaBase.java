package it.unicam.cs.bdslab.rnamlparsertool.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Enumerazione contenente tutte le possibili nomenclature dell'rna
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public enum RnaBase {
	ADENINE,
	URACIL,
	CYTOSINE,
	GUANINE,
	ADENINEorURACIL,
	ADENINEorCYTOSINE,
	ADENINEorGUANINE,
	URACILorCYTOSINE,
	URACILorGUANINE,
	CYTOSINEorGUANINE,
	notADENINE,
	notURACIL,
	notCYTOSINE,
	notGUANINE,
	UNIDENTIFIED;
	
	public static RnaBase getBase(int n) {
		return getBase("" + ((char) n));
	}
	
	public static RnaBase getBase(String s) {
		return getBase(s.toUpperCase().charAt(0));
	}
	
	public static RnaBase getBase(char c) {
		if(c >= 'a' && c <= 'z') {
			return getBase(""+c);
		}
		switch(c) {
			case 'A':
				return ADENINE;
			case 'U':
				return URACIL;
			case 'C':
				return CYTOSINE;
			case 'G':
				return GUANINE;
			case 'W':
				return ADENINEorURACIL;
			case 'M':
				return ADENINEorCYTOSINE;
			case 'R':
				return ADENINEorGUANINE;
			case 'Y':
				return URACILorCYTOSINE;
			case 'K':
				return URACILorGUANINE;
			case 'S':
				return CYTOSINEorGUANINE;
			case 'B':
				return notADENINE;
			case 'V':
				return notURACIL;
			case 'D':
				return notCYTOSINE;
			case 'H':
				return notGUANINE;
			default:
				return UNIDENTIFIED;
		}
	}
	
	public static char getBaseLetter (RnaBase base) {
		switch(base) {
			case ADENINE:
				return 'A';
			case URACIL:
				return 'U';
			case CYTOSINE:
				return 'C';
			case GUANINE:
				return 'G';
			case ADENINEorCYTOSINE:
				return 'R';
			case ADENINEorGUANINE:
				return 'Y';
			case ADENINEorURACIL:
				return 'M';
			case CYTOSINEorGUANINE:
				return 'B';
			case URACILorCYTOSINE:
				return 'K';
			case URACILorGUANINE:
				return 'S';
			case notADENINE:
				return 'V';
			case notCYTOSINE:
				return 'D';
			case notGUANINE:
				return 'H';
			case notURACIL:
				return 'V';
			default:
				return 'N';
		}
	}

	public static boolean maybeEquals(String seq1, String seq2){
		char [] list1 = seq1.toCharArray(), list2 = seq2.toCharArray();
		if(list1.length != list2.length)
			return false;
		for(int i = 0; i < list1.length; i++){
			if(!getBase(list1[i]).maybeEquals(getBase(list2[i])))
				return false;
		}
		return true;
	}

	
	public boolean maybeEquals(RnaBase other){
		if(this == UNIDENTIFIED || other == UNIDENTIFIED)
			return true;
		List<Character> list1 = getBases(this);
		List<Character> list2 = getBases(other);
		for(Character c : list1) {
			if(list2.contains(c))
				return true;
		}
		return false;
	}

	private List<Character> getBases(RnaBase base) {
		List<Character> list = new ArrayList<>();
		if(base == ADENINE || base == ADENINEorCYTOSINE || base == ADENINEorGUANINE || base == ADENINEorURACIL
			|| base == notCYTOSINE || base == notGUANINE || base == notURACIL)
			list.add('A');
		if(base == URACIL || base == URACILorCYTOSINE || base == URACILorGUANINE || base == ADENINEorURACIL
			|| base == notCYTOSINE || base == notGUANINE || base == notADENINE)
			list.add('U');
		if(base == CYTOSINE || base == ADENINEorCYTOSINE || base == CYTOSINEorGUANINE || base == URACILorCYTOSINE
			|| base == notADENINE || base == notGUANINE || base == notURACIL)
			list.add('C');
		if(base == GUANINE || base == URACILorGUANINE || base == ADENINEorGUANINE || base == CYTOSINEorGUANINE
			|| base == notCYTOSINE || base == notURACIL || base == notADENINE)
			list.add('G');
		return list;
	}

	public static boolean canonicalPair(RnaBase base1, RnaBase base2) {
		return checkCanonicalPatterns(base1, base2) || checkCanonicalPatterns(base2, base1);
	}

	private static boolean checkCanonicalPatterns(RnaBase base1, RnaBase base2) {
		return (base1.maybeEquals(RnaBase.ADENINE) && base2.maybeEquals(RnaBase.URACIL))
			|| (base1.maybeEquals(RnaBase.GUANINE) && base2.maybeEquals(RnaBase.CYTOSINE));
	}
	
}

