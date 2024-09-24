package it.unicam.cs.bdslab.rnamlparsertool.service.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import it.unicam.cs.bdslab.rnamlparsertool.abstraction.RnaFileWriter;
import it.unicam.cs.bdslab.rnamlparsertool.model.RnaMolecule;

public class TertiaryStructureWriter implements RnaFileWriter {

    @Override
    public boolean writeAndSave(RnaMolecule chains, String path) {
        try (FileWriter fw = new FileWriter(path, false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println("base-id-5p base-id-3p canonical-bond bond-type cis-or-trans");
            for (String[] pair : chains.getTertiaryStructure()) {
                String line = pair[0];
                for(int i = 1; i < pair.length; i++){
                    line += " " + pair[i];
                }
                out.println(line);
            }
            out.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }



}
