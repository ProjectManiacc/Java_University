/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CipherModel;
import model.InvalidCharacterException;
import view.CipherView;

/**
 *
 * @author piotrek
 * @version 1.0.0
 */
public class EncryptButtonListener implements ActionListener{
    private CipherModel model;
    private CipherView view;
    
    public EncryptButtonListener(CipherModel cipherModel, CipherView cipherView){
        this.model = cipherModel;
        this.view = cipherView;
    }
    
    @Override
        public void actionPerformed(ActionEvent event) {
            String inputText = view.getInputSentence();

            String encryptedText = " ";
        try {
            encryptedText = model.encrypt(inputText);
        } catch (InvalidCharacterException e) {
            System.out.println("Error: " + e.getMessage());
        }

            view.setOutputEncryptedSentence("Encrypted: " + encryptedText);
        }
}
