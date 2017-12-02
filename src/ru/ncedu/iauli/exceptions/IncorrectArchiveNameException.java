package ru.ncedu.iauli.exceptions;

/**
 * @author Ilya Ulitin
 */
public class IncorrectArchiveNameException extends Exception {

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized.
     */
    public IncorrectArchiveNameException() {
        super();
    }


    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized.
     *
     * @param message the detail message.
     */
    public IncorrectArchiveNameException(String message) {
        super(message);
    }
}