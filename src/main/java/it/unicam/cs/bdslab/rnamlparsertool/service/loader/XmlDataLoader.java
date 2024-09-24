package it.unicam.cs.bdslab.rnamlparsertool.service.loader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import it.unicam.cs.bdslab.rnamlparsertool.abstraction.RnaDataLoader;

/**
 * classe astratta per ottenere il document xml da un path
 * e operare sui nodi
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public abstract class XmlDataLoader implements RnaDataLoader {
	
	protected Document loadXmlDocument(String path, String dtdPath){
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			builder.setEntityResolver(new EntityResolver() {
				@Override
				public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
					if (systemId.contains(".dtd")) {
						InputStream dtdStream = getClass().getResourceAsStream(dtdPath);
						return new InputSource(dtdStream);
					} else {
						return null;
					}
				}
			});
			Document doc = builder.parse(new File(path));
		    doc.getDocumentElement().normalize();
		    return doc;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * se un nodo e' un elemento torna l'elemento, altrimenti null
	 * @param node
	 * @return
	 */
	protected Element getElement(Node node) {
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			return (Element) node;
		} else {
			return null;
		}
	}

}
