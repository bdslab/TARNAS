package it.unicam.cs.bdslab.tarnas.model.rnafile;

public class RNAFileException extends Exception {

    // Default constructor
    public RNAFileException() {
        super();
    }

    // Constructor that accepts a custom error message
    public RNAFileException(String message) {
        super(message);
    }

    // Constructor that accepts a custom error message and a cause
    public RNAFileException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public RNAFileException(Throwable cause) {
        super(cause);
    }
}
