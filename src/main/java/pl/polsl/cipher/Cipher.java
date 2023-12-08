/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pl.polsl.cipher;

import controller.CipherController;
import model.CipherModel;
import view.CipherView;

/**
 *
 * @author SuperStudent-PL
 */
public class Cipher {

    public static void main(String[] args) {
        CipherController cipherController = new CipherController();
        String sentense = cipherController.getUserSentense();
        
        CipherView cipherView = new CipherView();
        cipherView.showUserSentense(sentense);
        
        CipherModel cipherModel = new CipherModel();
        String encryptedSentense = cipherController.cipherSentense(cipherModel, sentense);
        cipherView.showEncryptedSentense(encryptedSentense);
        
    }
}
