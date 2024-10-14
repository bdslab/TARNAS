package it.unicam.cs.bdslab.rnamlparsertool.service.writer;
import it.unicam.cs.bdslab.rnamlparsertool.model.RnaMolecule;

public class FastaFileWriter extends TextFileWriter {

    @Override
    public boolean writeAndSave(RnaMolecule chains, String path) {
        data = "";
        data += chains.getchains().get(0).getSequence();
        return save(path);
    }
}
