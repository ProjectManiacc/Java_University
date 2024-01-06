//For some strange reason I could not generated java doc for this project

package pl.polsl.cipher;

import controller.CipherController;
import model.InvalidCharacterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.CipherModel;
import view.CipherView;
import controller.EncryptButtonListener;

/**
 * The main class for the Cipher application. This class handles the encryption
 * of a sentence based on command-line arguments or user input. The encrypted
 * sentence is then displayed using the CipherView class.
 *
 * @author Piotr Kluziok
 * @version 1.1.0
 */
public class Cipher {

    private static String sentence;
    private static String encryptedSentence;
    private static List<String> listSentences;
    private static List<String> encryptedListSentences;

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
        CipherView cipherView = new CipherView(args);
        sentence = cipherView.getInputSentence();

        cipherView.showUserSentence(sentence);
        CipherModel cipherModel = new CipherModel(sentence);

        cipherView.addEncryptButtonListener(new EncryptButtonListener(cipherModel, cipherView));

        try {
            encryptedSentence = cipherModel.encrypt(sentence);
        } catch (InvalidCharacterException e) {
            cipherView.showError(e.getMessage());
        }
        cipherView.showEncryptedSentence(encryptedSentence);
        
        List<String> listSentences = new ArrayList<String>(Arrays.asList("MOTYLE", "CUDAKI", "NIC"));
        cipherView.showUserListSentences(listSentences);
        CipherModel cipherModelSentences = new CipherModel(listSentences);
        
        try {
        encryptedListSentences = cipherModel.encryptSentences(listSentences);
        } catch (InvalidCharacterException e) {
            cipherView.showError(e.getMessage());
        }
        cipherView.showEncryptedListSentence(encryptedListSentences);
    }
}
