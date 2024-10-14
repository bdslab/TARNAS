package it.unicam.cs.bdslab.rnamlparsertool.utility;

import it.unicam.cs.bdslab.rnamlparsertool.abstraction.RnaDataLoader;
import it.unicam.cs.bdslab.rnamlparsertool.abstraction.RnaFileWriter;
import it.unicam.cs.bdslab.rnamlparsertool.service.loader.NullDataLoader;
import it.unicam.cs.bdslab.rnamlparsertool.service.writer.NullFileWriter;

/**
 * Implementazione di default per i casi non previsti.
 * Per aggiungere nuovi formati è necessario estendere diversamente
 * la classe astratta.
 *
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public class DefaultRnaHandlerBuilder extends RnaHandlerBuilder {

    @Override
    protected RnaFileWriter buildUnexpectedFileWriter(String path) {
        return new NullFileWriter();
    }

    @Override
    protected RnaDataLoader buildUnexpectedDataLoader(String path) {
        return new NullDataLoader();
    }

    @Override
    public String[] getSupportedExtensions() {
        return new String[]{"rnaml", "xml", "bpseq", "ct", "aas", "db", "fasta"};
    }

    @Override
    public String getDefaultExtension() {
        return "xml";
    }


}
