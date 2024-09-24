package it.unicam.cs.bdslab.rnamlparsertool.service.loader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import it.unicam.cs.bdslab.rnamlparsertool.exception.RnaParsingException;
import it.unicam.cs.bdslab.rnamlparsertool.model.RnaMolecule;
import it.unicam.cs.bdslab.rnamlparsertool.model.RnaChain;
import it.unicam.cs.bdslab.rnamlparsertool.utility.RnamlPairsLoader;

/**
 * classe per il caricamento di dati da un rnaml
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public final class RnamlDataLoader extends XmlDataLoader {
	/**
	 * Caricatore di coppie per l'rnaml
	 */
	private RnamlPairsLoader pairsLoader = new RnamlPairsLoader();

	@Override
	public RnaMolecule getData(String path) {
		RnaMolecule data = new RnaMolecule();
		Document doc = loadXmlDocument(path, "/rnaml.dtd");
		if(doc == null) {
			return null;
		}
		NodeList chainList = doc.getElementsByTagName("molecule");
		for (int i = 0; i < chainList.getLength(); i++) {
            Element node = getElement(chainList.item(i));
			RnaChain chain = getchain(node, i);
			if(chain == null)
				return null;
			data.addchain(chain);
		}
		checkInfoData(doc, data);
		try {
			data.checkSecondaryStructure();
			return data;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * metodo per ottenere una catena da un elemento
	 * di un xml e un indice
	 * @param chainData elemento di xml
	 * @param index indice
	 * @return catena se il parsing va correttamente, null altrimenti
	 */
	public RnaChain getchain(Element chainData, int index) {
		RnaChain chain = new RnaChain(index + 1);
		try {
			loadSequence(chainData, chain);
			this.pairsLoader.loadPairs(chainData, chain);
			return chain;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * carica la sequenza
	 * @throws RnaParsingException
	 */
	private void loadSequence(Element chainData, RnaChain chain) throws RnaParsingException {

		Element sequenceNode = getElement(chainData.getElementsByTagName("sequence")
				.item(0));
		NodeList list = sequenceNode.getElementsByTagName("seq-data");
				
		String sequence = getElement(list.item(0)).getTextContent()
							.replace(" ", "").replace("\n", "")
							.replace("\t", "").replace("\r", "").toUpperCase();
		for(char c : sequence.toCharArray()) {
			chain.addRibonucleotide(c);
		}
	}

	
	/**
	 * metodo che controlla se ci sono informazioni accessorie da inserire
	 * nei dati dal documento e, nel caso ci siano, le inserisce
	 * @param doc documento da controllare
	 * @param data dati in cui salvare le informazioni
	 */
	private void checkInfoData(Document doc, RnaMolecule data) {
		NodeList urls = doc.getElementsByTagName("url");
		if(urls.getLength() > 0){
			data.setReferenceLink(urls.item(0).getTextContent());
		}
		NodeList chainList = doc.getElementsByTagName("chain");
		if(chainList.getLength() > 0){
        	Element mol = getElement(chainList.item(0));
			String db = mol.getAttribute("database-ids");
			if(!"".equals(db)){
				data.setAccessionNumber(db);
			}
			NodeList identities = mol.getElementsByTagName("identity");
			if(identities.getLength() > 0) {
				String name = getElement(identities.item(0)).getElementsByTagName("name").item(0).getTextContent();
				data.setOrganism(name);
			}
		}
	}

	
}
