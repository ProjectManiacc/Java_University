package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
/**
 * The view class responsible for displaying information to the user.
 * This class provides methods for interacting with the user interface elements.
 *
 * @author Piotr Kluziok
 * @version 1.1.0
 */
public class CipherView extends JFrame {

   /** Command-line arguments provided to the program. */
    private String[] cmdArgs;

    /** Text field for entering the input sentence. */
    private JTextField inputSentence;

    /** Label for displaying the encrypted sentence. */
    private JLabel outputEncryptedSentence;

    /** Button for triggering the encryption process. */
    private JButton encryptSentenceButton;

    /** List for selecting sentences from a predefined set. */
    private JList<String> sentencesList;

    /**
     * Constructs a CipherView with command-line arguments.
     *
     * @param args The command-line arguments provided to the program.
     */
    public CipherView(String[] args) {
        cmdArgs = args;
        inputSentence = new JTextField(args[0]);
        outputEncryptedSentence = new JLabel("Encrypted:");
        encryptSentenceButton = new JButton("Encrypt");

        sentencesList = new JList<>(new String[]{"Select Sentence", "MOTYLE", "CUDAKI", "NIC", "Alamakota", "Ala ma kota", "ALAnieMaKota"});
        sentencesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(sentencesList);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        this.add(inputSentence);
        this.add(listScrollPane);
        this.add(outputEncryptedSentence);
        this.add(encryptSentenceButton);
        
        inputSentence.setToolTipText("Enter a sentence for encryption");
        sentencesList.setToolTipText("Select a sentence from the list or enter a custom sentence");
        encryptSentenceButton.setToolTipText("Click to encrypt the selected or entered sentence (Alt + E)");
        
        encryptSentenceButton.setMnemonic(KeyEvent.VK_E);

        inputSentence.setPreferredSize(new Dimension(200, 50));
        listScrollPane.setPreferredSize(new Dimension(200, 100));
        outputEncryptedSentence.setPreferredSize(new Dimension(200, 50));
        encryptSentenceButton.setPreferredSize(new Dimension(200, 50));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Retrieves the input sentence from either the selected item in the list or the text entered in the input field.
     *
     * @return The input sentence.
     */
    public String getInputSentence() {
        if ("Select Sentence".equals(sentencesList.getSelectedValue())) {
            return inputSentence.getText();
        }
        if (sentencesList.getSelectedValue() != null) {
            return sentencesList.getSelectedValue();
        }
        return inputSentence.getText();
    }

    /**
     * Sets the output encrypted sentence to be displayed.
     *
     * @param encryptedSentence The encrypted sentence to be displayed.
     */
    public void setOutputEncryptedSentence(String encryptedSentence) {
        outputEncryptedSentence.setText(encryptedSentence);
    }

    /**
     * Adds an ActionListener to the encryptSentenceButton.
     *
     * @param listener The ActionListener to be added.
     */
    public void addEncryptButtonListener(ActionListener listener) {
        encryptSentenceButton.addActionListener(listener);
    }

    /**
     * Displays the user's input sentence.
     *
     * @param sentence The user's input sentence to be displayed.
     */
    public void showUserSentence(String sentence) {
        System.out.println("User sentence: " + sentence);
    }

    /**
     * Displays the list of user sentences.
     *
     * @param listSentences The list of user sentences to be displayed.
     */
    public void showUserListSentences(List<String> listSentences) {
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

    /**
     * Displays the list of encrypted sentences.
     *
     * @param sentence The list of encrypted sentences to be displayed.
     */
    public void showEncryptedListSentence(List<String> sentence) {
        System.out.println("Encrypted sentences: " + sentence);
    }

    /**
     * Displays an error message related to invalid characters during encryption.
     *
     * @param message The error message to be displayed.
     */
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, "Error: " + message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
