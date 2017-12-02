package ru.ncedu.iauli.exceptions;

/**
 * @author Ilya Ulitin
 */
public class IncorrectFileNameException extends Exception {

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized.
     */
    public IncorrectFileNameException() {
        super();
    }


    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized.
     *
     * @param message the detail message.
     */
    public IncorrectFileNameException(String message) {
        super(message);
    }
}
