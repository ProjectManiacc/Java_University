package model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.CipherModel;
import model.InvalidCharacterException;
import view.CipherView;

/**
 * ActionListener for the Encrypt button in the CipherView.
 * This class handles the action event triggered by the Encrypt button,
 * encrypting the input sentence and updating the view accordingly.
 *
 * @author Piotr Kluziok
 * @version 1.0.1
 */
public class EncryptButtonListener implements ActionListener {

    private CipherModel model;
    private CipherView view;

    /**
     * Constructs an EncryptButtonListener with the specified CipherModel and CipherView.
     *
     * @param cipherModel The CipherModel to handle encryption.
     * @param cipherView  The CipherView to update with the encrypted result.
     */
    public EncryptButtonListener(CipherModel cipherModel, CipherView cipherView) {
        this.model = cipherModel;
        this.view = cipherView;
    }

    /**
     * Handles the action event triggered by the Encrypt button.
     * Encrypts the input sentence using the CipherModel and updates the CipherView.
     *
     * @param event The action event triggered by the Encrypt button.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        String inputText = view.getInputSentence();
        String encryptedText = " ";

        try {
            encryptedText = model.encrypt(inputText);
        } catch (InvalidCharacterException e) {
            view.showError(e.getMessage());
        }

        view.setOutputEncryptedSentence("Encrypted: " + encryptedText);
    }
}

