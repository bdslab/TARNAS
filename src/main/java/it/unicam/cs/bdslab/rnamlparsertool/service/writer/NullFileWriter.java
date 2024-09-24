package it.unicam.cs.bdslab.rnamlparsertool.service.writer;

import it.unicam.cs.bdslab.rnamlparsertool.abstraction.RnaFileWriter;
import it.unicam.cs.bdslab.rnamlparsertool.model.RnaMolecule;

/**
 * classe simbolica per indicare che non è stata
 * trovata una classe adeguata per scrivere i dati
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public final class NullFileWriter implements RnaFileWriter {

    @Override
    public boolean writeAndSave(RnaMolecule chains, String path) {
        return false;
    }

}
