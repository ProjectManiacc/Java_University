package model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Annotation;
import model.InvalidCharacterException;
/**
 * The model class representing the original sentence to be encrypted.
 * This class provides methods for encrypting a single sentence or a list of sentences.
 *
 * @author Piotr Kluziok
 * @version 1.3.1
 */
public class CipherModel {

    @Annotation(value = "Original Sentence")
    private String originalSentence = null;

    @Annotation(value = "List of Original Sentences")
    private List<String> originalListSentences = null;

    /**
     * Constructs a CipherModel with the original sentence.
     *
     * @param originalSentence The original sentence to be encrypted.
     */
    public CipherModel(String originalSentence) {
        this.originalSentence = originalSentence;
    }

    /**
     * Constructs a CipherModel with a list of original sentences.
     *
     * @param originalSentences The list of original sentences to be encrypted.
     */
    public CipherModel(List<String> originalSentences) {
        this.originalListSentences = originalSentences;
    }

    /**
     * Gets the original sentence.
     *
     * @return The original sentence.
     */
    public String getOriginalSentence() {
        return originalSentence;
    }

    /**
     * Gets the list of original sentences.
     *
     * @return The list of original sentences.
     */
    public List<String> getOriginalListSentences() {
        return originalListSentences;
    }

    /**
     * Encrypts the given sentence by reversing characters in pairs.
     *
     * @param sentence The sentence to encrypt.
     * @return The encrypted sentence.
     * @throws InvalidCharacterException If an invalid character is encountered during encryption.
     */
    public String encrypt(String sentence) throws InvalidCharacterException {
        StringBuilder encrypted = new StringBuilder();

        if (sentence == null || sentence.isEmpty()) {
            throw new InvalidCharacterException("Invalid input: null or empty sentence");
        }

        for (int i = 0; i < sentence.length(); i += 2) {
            char firstChar = sentence.charAt(i);

            if (i + 1 < sentence.length()) {
                char secondChar = sentence.charAt(i + 1);

                if (Character.isLetter(firstChar) && Character.isLetter(secondChar)) {
                    encrypted.append(secondChar);
                    encrypted.append(firstChar);
                } else {
                    throw new InvalidCharacterException("Invalid Characters: " + secondChar);
                }
            } else {
                encrypted.append(firstChar);
            }
        }

        return encrypted.toString();
    }

    /**
     * Encrypts a list of sentences by calling the encrypt method for each sentence.
     *
     * @param sentences The list of sentences to encrypt.
     * @return The list of encrypted sentences.
     * @throws InvalidCharacterException If an invalid character is encountered during encryption.
     */
    public List<String> encryptSentences(List<String> sentences) throws InvalidCharacterException {
        List<String> encryptedSentences = new ArrayList<>();
        sentences.forEach(sentence -> {
            try {
                encryptedSentences.add(encrypt(sentence));
            } catch (InvalidCharacterException ex) {
                //Logger.getLogger(CipherModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return encryptedSentences;
    }
}

