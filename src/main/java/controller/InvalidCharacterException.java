package controller;

/**
 * Custom exception class to represent an error when an invalid character is
 * encountered.
 *
 * @author Piotr Kluziok
 */
public class InvalidCharacterException extends Exception {

    /**
     * Constructs an InvalidCharacterException with the specified detail
     * message.
     *
     * @param message the detail message.
     */
    public InvalidCharacterException(String message) {
        super(message);
    }
}
