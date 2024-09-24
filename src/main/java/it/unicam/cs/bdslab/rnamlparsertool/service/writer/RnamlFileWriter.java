package it.unicam.cs.bdslab.rnamlparsertool.service.writer;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map.Entry;

import org.w3c.dom.Element;

import it.unicam.cs.bdslab.rnamlparsertool.model.RnaMolecule;
import it.unicam.cs.bdslab.rnamlparsertool.model.RnaChain;

/**
 * Classe per il salvataggio di dati nel formato RNAML
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public final class RnamlFileWriter extends XmlFileWriter {

    /**
     * Element root, in questo caso sarà un nodo <rnaml> ... </rnaml>
     */
    private Element root;

    @Override
    public boolean writeAndSave(RnaMolecule chains, String path) {
        createNewDocument();
        this.root = xmlDoc.createElement("rnaml");
        root.setAttribute("version", "1.0");
        xmlDoc.appendChild(root);
        for(RnaChain chain : chains.getchains()) {
            addchain(chain, chains.getAccessionNumber(), chains.getOrganism());
            setgetReferenceLink(chains.getReferenceLink(), chain.getchainId());
        }
        return save(path, "rnaml.dtd");
    }

    /**
     * metodo per aggiungere una catena alla radice
     * @param chain catena da aggiungere
     * @param accessionNumer numero di accesso al db
     * @param organism nome dell'organismo
     */
    private void addchain(RnaChain chain, String accessionNumer, String organism) {
        Element mol = xmlDoc.createElement("chain");
        mol.setAttribute("id", "" + chain.getchainId());
        if(accessionNumer != null){
            mol.setAttribute("database-ids", accessionNumer);
        }
        root.appendChild(mol);
        setIdentity(mol, organism);
        Element seq = xmlDoc.createElement("sequence");
        mol.appendChild(seq);
        Element seq_data = xmlDoc.createElement("seq-data");
        seq_data.appendChild(xmlDoc.createTextNode(sequenceStyle(chain.getSequence())));
        seq.appendChild(seq_data);
        Element struct = xmlDoc.createElement("structure");
        mol.appendChild(struct);
        Element model = xmlDoc.createElement("model");
        struct.appendChild(model);
        Element str_ann = xmlDoc.createElement("str-annotation");
        model.appendChild(str_ann);
        List<Entry<Integer, Integer>> pairs = chain.getPairMap().entrySet().stream()
											.map(x -> x.getKey() < x.getValue() ? x : new SimpleEntry<Integer, Integer>(x.getValue(), x.getKey()))
											.distinct().toList();
        for(Entry<Integer, Integer> pair : pairs) {
            Element base_pair = xmlDoc.createElement("base-pair");
            str_ann.appendChild(base_pair);
            addBase(base_pair, "base-id-5p", pair.getKey());
            addBase(base_pair, "base-id-3p", pair.getValue());
        }
    }

    
    /**
     * Imposta il link di riferimento, se esiste
     * @param referenceLink link di riferimento
     * @param chainId id della catena
     */
    private void setgetReferenceLink(String referenceLink, int chainId){
        if(referenceLink != null) {
            Element reference = xmlDoc.createElement("reference");
            reference.setAttribute("id", "" + chainId);
            root.appendChild(reference);
            Element pa = xmlDoc.createElement("path");
            reference.appendChild(pa);
            Element url = xmlDoc.createElement("url");
            url.appendChild(xmlDoc.createTextNode(referenceLink));
            pa.appendChild(url);
        }
    }

    /**
     * Imposta l'identità, se esiste
     * @param mol elemento della catena
     * @param organism nome dell'organismo
     */
    private void setIdentity(Element mol, String organism){
        if(organism != null){
            Element identity = xmlDoc.createElement("identity");
            mol.appendChild(identity);
            Element name = xmlDoc.createElement("name");
            name.appendChild(xmlDoc.createTextNode(organism));
            identity.appendChild(name);
        }
    }

    /**
     * aggiusta la stringa contenente la sequenza di ribonucleidi
     * in modo da renderla più leggibile nel file xml
     * @param sequence sequenza grezza
     * @return sequenza raffinata
     */
    private String sequenceStyle(String sequence) {
        String result = "\n        ";
        int count = 0;
        for(char c : sequence.toCharArray()) {
            if(count != 0) {
                if(count % 60 == 0)
                    result += "\n        ";
                else if(count % 10 == 0)
                    result += ' ';
            }
            result += c;
            count++;
        }
        return result + "\n      ";
    }

    /**
     * aggiunge una parte di una coppia di basi nella struttura secondaria 
     * @param base_pair elemento di partenza
     * @param id id dell'elemento della coppia
     * @param pos posizione dell'elemento
     */
    private void addBase(Element base_pair, String id, int pos) {
        Element base_p = xmlDoc.createElement(id);
        base_pair.appendChild(base_p);
        Element base_id = xmlDoc.createElement("base-id");
        base_p.appendChild(base_id);
        Element position = xmlDoc.createElement("position");
        position.appendChild(xmlDoc.createTextNode(pos+""));
        base_id.appendChild(position);
    }
    
    
}
