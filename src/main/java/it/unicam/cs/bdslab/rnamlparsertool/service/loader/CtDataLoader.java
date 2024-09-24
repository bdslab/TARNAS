package it.unicam.cs.bdslab.rnamlparsertool.service.loader;

/**
 * classe per caricare i dati contenuti in un file CT
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public final class CtDataLoader extends TableDataLoader {

    public CtDataLoader(){
        this.basePosition = 1;
        this.dimension = 6;
        this.pairOnePosition = 0;
        this.pairTwoPosition = 4;
    }
}
