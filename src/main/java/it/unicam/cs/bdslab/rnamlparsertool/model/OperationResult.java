package it.unicam.cs.bdslab.rnamlparsertool.model;

import java.util.ArrayList;
import java.util.List;

/**
 * classe per contenere l'esito e i dettagli di un operazione
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public class OperationResult {

    /**
     * dettagli
     */
    private List<String> info;
    /**
     * esito
     */
    public boolean result;

    public OperationResult() {
        this.info = new ArrayList<>();
        result = false;
    }

    public List<String> getInfo() {
        return new ArrayList<>(info);
    }

    public void addInfo(String info) {
        this.info.add(info);
    }
    

}
