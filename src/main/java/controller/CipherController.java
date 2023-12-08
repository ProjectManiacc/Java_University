package controller;

import java.util.Scanner;

/**
 * Controller class responsible for handling user input and encryption. This
 * class provides methods for reading a user's sentence and encrypting it.
 *
 * @author Piotr Kluziok
 */
public class CipherController {

    /**
     * Reads a sentence from the user for encryption.
     *
     * @return The sentence entered by the user.
     */
    public String readUserSentence() {
        System.out.println("Please type a sentence for encrypting\n");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        return sentence;
    }

    /**
     * Encrypts the given sentence.
     *
     * @param sentence The sentence to encrypt.
     * @return The encrypted sentence.
     * @throws InvalidCharacterException If an invalid character is encountered
     * during encryption.
     */
    public static String encrypt(String sentence) throws InvalidCharacterException {
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

    /**
     * Encrypts a single character.
     *
     * @param letter The character to encrypt.
     * @return The encrypted character.
     */
    public static char encryptChar(char letter) {
        if (Character.isLowerCase(letter)) {
            return (char) ('z' - (letter - 'a'));
        } else if (Character.isUpperCase(letter)) {
            return (char) ('Z' - (letter - 'A'));
        } else {
            return letter;
        }
    }
}
