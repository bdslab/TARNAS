package it.unicam.cs.bdslab.rnamlparsertool.utility;

import it.unicam.cs.bdslab.rnamlparsertool.abstraction.RnaDataLoader;
import it.unicam.cs.bdslab.rnamlparsertool.abstraction.RnaFileWriter;
import it.unicam.cs.bdslab.rnamlparsertool.service.loader.*;
import it.unicam.cs.bdslab.rnamlparsertool.service.writer.*;

/**
 * Classe che genera il gestore adatto al contesto
 * in base al metodo chiamato e al nome del file
 *
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public abstract class RnaHandlerBuilder {

    /**
     * Metodo per ottenere il giusto scrittore di
     * dati per un certo path
     *
     * @param path path in cui salvare
     * @return scrittore di dati adatto
     */
    public final RnaFileWriter buildFileWriter(String path) {
        String extension = getExtension(path);
        return switch (extension) {
            case "rnaml", "xml" -> new RnamlFileWriter();
            case "bpseq" -> new BpseqFileWriter();
            case "ct" -> new CtFileWriter();
            case "aas" -> new AasFileWriter();
            case "db" -> new DbFileWriter();
            case "fasta" -> new FastaFileWriter();
            default -> buildUnexpectedFileWriter(path);
        };
    }

    protected abstract RnaFileWriter buildUnexpectedFileWriter(String path);

    /**
     * Metodo per ottenere il giusto caricatore di
     * dati per un certo path
     *
     * @param path path da caricare
     * @return caricatore di dati adatto
     */
    public final RnaDataLoader buildDataLoader(String path) {
        String extension = getExtension(path);
        return switch (extension) {
            case "rnaml", "xml" -> new RnamlDataLoader();
            case "bpseq" -> new BpseqDataLoader();
            case "ct" -> new CtDataLoader();
            case "aas" -> new AasDataLoader();
            case "db" -> new DbDataLoader();
            default -> buildUnexpectedDataLoader(path);
        };
    }


    protected abstract RnaDataLoader buildUnexpectedDataLoader(String path);

    /**
     * Metodo interno per ottenere l'estensione del file
     *
     * @param path nome del file
     * @return estensione del file
     */
    private String getExtension(String path) {
        String[] parts = path.split("\\.");
        if (parts.length < 2)
            return "";
        String ext = parts[parts.length - 1];
        if (ext.equals("txt") && parts.length > 2)
            return parts[parts.length - 2];
        return ext;
    }

    public abstract String[] getSupportedExtensions();

    public abstract String getDefaultExtension();


}
