/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;
import model.CipherModel;

/**
 *
 * @author SuperStudent-PL
 */
public class CipherController {
    
    public String getUserSentense(){
    Scanner scanner = new Scanner(System.in);

    String sentense = scanner.nextLine();
    
    return sentense;
    }
    
    
    public String cipherSentense(CipherModel cipher,String sentense){
        //placeholder for encrypting
        String encryptedSentense = new StringBuilder(sentense).reverse().toString();
        return encryptedSentense;
        }
    
//    public String cipher(){
//    }
}

    


