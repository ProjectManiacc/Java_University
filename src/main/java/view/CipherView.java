package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 * The view class responsible for displaying information to the user.
 *
 * @author Piotr Kluziok
 * @version 1.1.0
 */
public class CipherView extends JFrame {
    
    private String[] cmdArgs;
    private JTextField inputSentence;
    private JLabel outputEncryptedSentence;
    private JButton encryptSentenceButton;
    private JList<String> sentencesList;
    
    
    public CipherView(String[] args){
        cmdArgs = args;
        inputSentence = new JTextField(args[0]);
        outputEncryptedSentence = new JLabel("Encrypted:");
        encryptSentenceButton = new JButton("Encrypt");
        
        sentencesList = new JList<>(new String[]{"Select Sentence", "MOTYLE", "CUDAKI", "NIC"});
        sentencesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(sentencesList);
        //sentencesList = new JComboBox<>(new String[]{"Select Sentence", "MOTYLE", "CUDAKI", "NIC"});

     
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        
        this.add(inputSentence);
        this.add(sentencesList);
        this.add(outputEncryptedSentence);
        this.add(encryptSentenceButton);
        
        inputSentence.setPreferredSize( new Dimension(300,50));
        sentencesList.setPreferredSize( new Dimension(300,50));
        outputEncryptedSentence.setPreferredSize( new Dimension(300,50));
        encryptSentenceButton.setPreferredSize( new Dimension(300,50));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
    
    public String getInputSentence(){
        
        
        if (sentencesList.getSelectedValue() == "Select Sentence"){
            return inputSentence.getText();
        }
        if (sentencesList.getSelectedValue() != null) {
            return sentencesList.getSelectedValue();
        }
        // Otherwise, return the text entered in the input field
        return inputSentence.getText();
    }
    
    public void setOutputEncryptedSentence(String encryptedSentence){
        outputEncryptedSentence.setText(encryptedSentence);
    }
    
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
