package it.unicam.cs.bdslab.rnamlparsertool.model;

/**
 * classe che contiene una coppia di posizioni
 * unita ad un livello di ordine, indispensabile
 * per l'applicazione dell'algoritmo di scrittura
 * di file db
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public class DbPair implements Comparable<DbPair> {

    private final int left;
    private final int right;
    private int order;

    public DbPair(int left, int right){
        this.left = left;
        this.right = right;
        this.order = 0;
    }

    public int getLeft() {
        return left;
    }
    
    public int getRight() {
        return right;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + left;
        result = prime * result + right;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DbPair)) {
            return false;
        }
        DbPair other = (DbPair) obj;
        return this.left == other.left && this.right == other.right;
    }

    @Override
    public int compareTo(DbPair o) {
        Integer right, oright;
        right = this.right;
        oright = o.right;
        return right.compareTo(oright);
    }

}