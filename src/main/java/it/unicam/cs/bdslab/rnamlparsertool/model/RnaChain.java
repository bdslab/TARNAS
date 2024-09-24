package it.unicam.cs.bdslab.rnamlparsertool.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import it.unicam.cs.bdslab.rnamlparsertool.exception.RnaParsingException;

/**
 * classe che contiene tutti i dati relativi ad un rna
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public class RnaChain {
	
	private int chainId;
	private Map<Integer, RnaRibonucleotide> chain;
	private Map<Integer, Integer> pairs;
	private List<String[]> tertiaryPairs;
	private int maxReference = 0;
	
	public RnaChain(int chainId) {
		this.chainId = chainId;
		this.chain = new HashMap<>();
		this.pairs = new HashMap<>();
		this.tertiaryPairs = new ArrayList<>();
	}

	public int getchainId() {
		return this.chainId;
	}

	public int getMaxReference(){
		return maxReference;
	}
	
	public void addRibonucleotide(char c) throws RnaParsingException {
		int pos = getLength() + 1;
		try {
			RnaBase base = RnaBase.getBase(c);
			RnaRibonucleotide obj = new RnaRibonucleotide(this.chainId, pos, base);
			this.chain.put(pos, obj);
		}catch(Exception e) {
			throwException(pos);
		}
	}

	public void addPair(int first, int second) throws RnaParsingException {
		addPair(first, second, "W", "W");
	}
	
	public void addPair(int first, int second, String bt1, String bt2) throws RnaParsingException {
		if( first < 1 )
			throwException(first);
		if( first == second || second < 1 )
			throwException(second);
		if(this.pairs.containsKey(first) || this.pairs.containsKey(second)){
			addTertiaryPair(first, second, true, bt1, bt2);
		} else {
			pairs.put(first, second);
			pairs.put(second, first);
		}
	}
	public void addTertiaryPair(int first, int second, boolean isCis, String bt1, String bt2) throws RnaParsingException {
		if( first < 1 )
			throwException(first);
		if( first == second || second < 1 )
			throwException(second);
		String firstPair = getBaseOf(first) + first;
		String secondPair = getBaseOf(second) + second;
		String canon = isCanonical(first, second) ? "Canonical-Pair" : "Not-Canonical-Pair";
		String bond = getBond(bt1, bt2, isCis);
		tertiaryPairs.add(new String[]{firstPair, secondPair, canon, bond});
	}

	private String getBond(String bt1, String bt2, boolean isCis) {
		return getLate(bt1) + "-" + getLate(bt2) + (isCis ? " cis" : " trans");
	}

	private String getLate(String letter){
		switch (letter) {
			case "H":
				return "Hoogsteen";
			case "S":
				return "Sugar";
			case "W":
				return "Watson-Crick";
			case "+":
				return "Watson-Crick";
			case "-":
				return "Watson-Crick";
			default:
				return "???";
		}
	}

	public String getBaseOf(int index){
		RnaRibonucleotide ribo = this.chain.get(index);
		return ribo==null ? "N" : "" + RnaBase.getBaseLetter(ribo.getBase());
	}

	public boolean isCanonical(int i1, int i2){
		RnaRibonucleotide ribo1 = this.chain.get(i1);
		RnaRibonucleotide ribo2 = this.chain.get(i2);
		if(ribo1 == null || ribo2 == null)
			return false;
		return RnaBase.canonicalPair(ribo1.getBase(), ribo2.getBase());
	}
	
	public int getLength() {
		return this.chain.size();
	}
	
	public String getSequence() {
		String out = "";
		final int len = getLength();
		for(int i = 1; i <= len; i++) {
			out += this.chain.get(i);
		}
		return out;
	}
	
	public Map<Integer, Integer> getPairMap(){
		Map<Integer, Integer> map = new HashMap<>();
		for(Entry<Integer, Integer> pair : pairs.entrySet()) {
			map.put(pair.getKey(), pair.getValue());
		}
		return map;
	}

	public boolean haveTertiaryData(){
		return !this.tertiaryPairs.isEmpty();
	}

	public List<String[]> getTertiaryStructure(){
		List<String[]> list = new ArrayList<>();
		if(!haveTertiaryData())
			return list;
		list.addAll(tertiaryPairs);
		return list;
	}
	
	private void throwException(int pos) throws RnaParsingException {
		throw new RnaParsingException(this.chainId, pos);
	}
	
}
