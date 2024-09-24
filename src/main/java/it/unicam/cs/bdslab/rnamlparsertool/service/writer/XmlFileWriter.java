package it.unicam.cs.bdslab.rnamlparsertool.service.writer;

import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

import it.unicam.cs.bdslab.rnamlparsertool.abstraction.RnaFileWriter;

/**
 * Classe astratta per fornire i metodi utili all'estrapolazione
 * del document e il salvataggio in un formato basato sull'xml
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public abstract class XmlFileWriter implements RnaFileWriter {
    /**
     * Document su cui scrivere
     */
    protected Document xmlDoc;

    /**
     * Metodo per ottenere un nuovo documento
     */
    protected void createNewDocument(){
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            this.xmlDoc = dBuilder.newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo per salvare l'attuale documento
     * in uno specifico path e tramite un dtd fornito tramite
     * riferimento esterno
     * @param path path di destinazione
     * @param dtd path del file.dtd
     * @return true se il salvataggio va a buon fine, false altrimenti
     */
    protected boolean save(String path, String dtd) {
        try {
            Source source = new DOMSource(xmlDoc);
            File xmlFile = new File(path);
            StreamResult result = new StreamResult(new OutputStreamWriter(
                    new FileOutputStream(xmlFile), "ISO-8859-1"));
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, dtd);
            xformer.setOutputProperty(OutputKeys.INDENT, "yes");
            xformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            xformer.transform(source, result);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
