package model;

import java.util.ArrayList;
import java.util.List;
import model.Annotation;



/**
 * The model class representing the original sentence to be encrypted.
 *
 * @author Piotr Kluziok
 * @version 1.2.0
 */
public class CipherModel {
    @Annotation( value = "Original Sentence")
    private String originalSentence = null;
    
    @Annotation( value = "List of Original Sentences")
    private List<String> originalListSentences = null;
    /**
     * Constructs a CipherModel with the original sentence.
     *
     * @param originalSentence The original sentence to be encrypted.
     */
    public CipherModel(String originalSentence) {
        this.originalSentence = originalSentence;
    }
    
    public CipherModel(List<String> originalSentences){
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
    
    public List<String> getOriginalListSentences() {
        return originalListSentences;
    }
    
        /**
     * Encrypts the given sentence.
     *
     * @param sentence The sentence to encrypt.
     * @return The encrypted sentence.
     * @throws InvalidCharacterException If an invalid character is encountered
     * during encryption.
     */
    public String encrypt(String sentence) throws InvalidCharacterException {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);
            if (Character.isLetter(currentChar)) {
                char encryptedChar = encryptChar(currentChar);
                encrypted.append(encryptedChar);
            } else {
                throw new InvalidCharacterException("Invalid Character: " + currentChar);
            }
        }
        return encrypted.toString();
    }
    
    public List<String> encryptSentences(List<String> sentences) throws InvalidCharacterException {
        List<String> encryptedSentences = new ArrayList<>();
        sentences.forEach( sentence -> {
            try {
                encryptedSentences.add(encrypt(sentence));
            }catch (InvalidCharacterException e){
                System.err.println("Error encrypting sentence: " + e.getMessage());
            }
        });
                
        
//        for (String sentence : sentences) {
//            encryptedSentences.add(encrypt(sentence));
//        }
        return encryptedSentences;
    }
    

    /**
     * Encrypts a single character.
     *
     * @param letter The character to encrypt.
     * @return The encrypted character.
     */
    private char encryptChar(char letter) {
        if (Character.isLowerCase(letter)) {
            return (char) ('z' - (letter - 'a'));
        } else if (Character.isUpperCase(letter)) {
            return (char) ('Z' - (letter - 'A'));
        } else {
            return letter;
        }
    }
}
