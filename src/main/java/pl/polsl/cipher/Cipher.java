//For some strange reason I could not generated java doc for this project

package pl.polsl.cipher;

import controller.CipherController;
import controller.InvalidCharacterException;
import model.CipherModel;
import view.CipherView;

/**
 * The main class for the Cipher application. This class handles the encryption
 * of a sentence based on command-line arguments or user input. The encrypted
 * sentence is then displayed using the CipherView class.
 *
 * @author Piotr Kluziok
 */
public class Cipher {

    private static String sentence;
    private static String encryptedSentence;

    /**
     * The main method for the Cipher application.
     *
     * If a sentence is provided as a command-line argument, it will be
     * encrypted. Otherwise, the user will be prompted to enter a sentence for
     * encryption.
     *
     * @param args The command-line arguments provided to the program. If a
     * sentence is provided, it will be encrypted.
     *
     * throws InvalidCharacterException If an invalid character is encountered
     * during encryption.
     */
    public static void main(String[] args) {
        // Only the first argument entered from the console will be used and accpepted.
        // It Has to be sentence that needs to be encrypted.
        CipherController cipherController = new CipherController();

        if (args.length == 1) {
            sentence = args[0];
        } else {
            sentence = cipherController.readUserSentence();
        }

        CipherView cipherView = new CipherView();
        cipherView.showUserSentence(sentence);

        CipherModel cipherModel = new CipherModel(sentence);
        try {
            encryptedSentence = CipherController.encrypt(cipherModel.getOriginalSentence());
        } catch (InvalidCharacterException e) {
            cipherView.showError(e.getMessage());
        }
        cipherView.showEncryptedSentence(encryptedSentence);

    }
}
