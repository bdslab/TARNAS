package it.unicam.cs.bdslab.rnamlparsertool.utility;

/**
 * Classe astratta per la traduzione di numeri nei caratteri DB e viceversa
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public abstract class DotBracketTranslator {
    /**
     * Simboli base della dicitura DB
     */
    private final char [] symbols = {'.', '(', ')', '[', ']', '{', '}', '<', '>'};
    
    /**
     * Metodo per ottenere il corrispettivo carattere di un numero
     * @param n numero da tradurre
     * @return carattere tradotto
     */
    public char getDbBracket(int n){
        n = n < 0 || n > 62 ? 0 : n;
        return n < 9 ? symbols[n] : ((char) 
                                    ((n % 2 != 0 ? 'A' : 'a')
                                    + (n - 9) / 2));
    }

    /**
     * Metodo per ottenere il corrispettivo numero di un carattere
     * @param c carattere da tradurre
     * @return numero tradotto
     */
    public int getDbNumber(char c) {
        for(int i = 0; i < symbols.length; i++) {
            if(symbols[i] == c)
                return i;
        }
        boolean maiusc = c >= 'A' && c <= 'Z';
        boolean minusc = c >= 'a' && c <= 'z';
        if(!(maiusc || minusc))
            return 0;
        int base = (c - (maiusc ? 'A' : 'a'));
        return ((base * 2) + 9) + (maiusc ? 0 : 1);
    }

}
