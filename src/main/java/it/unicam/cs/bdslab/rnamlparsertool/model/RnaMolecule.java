package it.unicam.cs.bdslab.rnamlparsertool.model;

import java.util.ArrayList;
import java.util.List;

import it.unicam.cs.bdslab.rnamlparsertool.exception.RnaParsingException;

/**
 * classe che contiene tutti i dati relativi ad uno specifico file rna
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public class RnaMolecule {
    
    private List<RnaChain> chains;
    private String organism, accessionNumber, referenceLink;

    public RnaMolecule(){
        this.chains = new ArrayList<>();
    }

    public void addchain(RnaChain chain){
        this.chains.add(chain);
    }

    public List<RnaChain> getchains(){
        List<RnaChain> list = new ArrayList<>();
        list.addAll(this.chains);
        return list;
    }

    public String getOrganism() {
        return organism;
    }

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public String getReferenceLink() {
        return referenceLink;
    }

    public void setOrganism(String organism) {
        this.organism = organism;
    }

    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    public void setReferenceLink(String referenceLink) {
        this.referenceLink = referenceLink;
    }

    public void checkSecondaryStructure() throws RnaParsingException {
        for(RnaChain chain : this.chains) {
            if(chain.getMaxReference() > getLength()) {
                throw new RnaParsingException(chain.getchainId(), chain.getMaxReference());
            }
        }
    }

    public int getLength() {
        return this.chains.stream().map(x -> x.getLength()).reduce(0, (a, b) -> a + b);
    }

    public boolean haveTertiaryData(){
		return this.chains.stream().anyMatch(x -> x.haveTertiaryData());
	}

	public List<String[]> getTertiaryStructure(){
		return this.chains.stream()
        .map(x -> x.getTertiaryStructure())
        .reduce(new ArrayList<>(), (a,b) -> {a.addAll(b); return a;} );
	}

}
