package model;

/**
 * The model class representing the original sentence to be encrypted.
 *
 * @author Piotr Kluziok
 */
public class CipherModel {

    private final String originalSentence;

    /**
     * Constructs a CipherModel with the original sentence.
     *
     * @param originalSentence The original sentence to be encrypted.
     */
    public CipherModel(String originalSentence) {
        this.originalSentence = originalSentence;
    }

    /**
     * Gets the original sentence.
     *
     * @return The original sentence.
     */
    public String getOriginalSentence() {
        return originalSentence;
    }
}
