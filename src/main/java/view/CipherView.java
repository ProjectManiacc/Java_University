package view;

import java.util.List;

/**
 * The view class responsible for displaying information to the user.
 *
 * @author Piotr Kluziok
 */
public class CipherView {

    /**
     * Displays the user's input sentence.
     *
     * @param sentence The user's input sentence to be displayed.
     */
    public void showUserSentence(String sentence) {
        System.out.println("User sentence: " + sentence);
    }
    
    public void showUserListSentences(List<String> listSentences){
        System.out.println("User sentences: " + listSentences);
    }

    /**
     * Displays the encrypted sentence.
     *
     * @param sentence The encrypted sentence to be displayed.
     */
    public void showEncryptedSentence(String sentence) {
        System.out.println("Encrypted sentence: " + sentence);
    }
    
    public void showEncryptedListSentence(List<String> sentence) {
        System.out.println("Encrypted sentences: " + sentence);
    }

    /**
     * Displays an error message related to invalid characters during
     * encryption.
     *
     * @param message The error message to be displayed.
     */
    public void showError(String message) {
        System.out.println("Error: " + message);
        System.out.println("Application accepts only letters for encryption.");
    }

}
