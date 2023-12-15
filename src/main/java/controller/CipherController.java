package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Controller class responsible for handling user input and encryption. This
 * class provides methods for reading a user's sentence and encrypting it.
 *
 * @author Piotr Kluziok
 * @version 1.0.0
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


}
