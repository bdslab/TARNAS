package it.unicam.cs.bdslab.rnamlparsertool.service.loader;

/**
 * classe per caricare i dati contenuti in un file bpseq
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public final class BpseqDataLoader extends TableDataLoader {

    public BpseqDataLoader(){
        this.basePosition = 1;
        this.dimension = 3;
        this.pairOnePosition = 0;
        this.pairTwoPosition = 2;
    }
    
}
