/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import controller.InvalidCharacterException;
import java.util.List;
import model.CipherModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author piotrek
 */
public class TestCipherModel {
    
    public TestCipherModel() {
    }
    
    @ParameterizedTest
    @ValueSource( strings = {"Alamakota"})
    void testEncryptSentencesCorrect(String originalSentence) throws InvalidCharacterException {
        CipherModel cipherModel = new CipherModel(originalSentence);

        String encryptedSentence = cipherModel.encrypt(cipherModel.getOriginalSentence());
        assertEquals("Zoznzplgz", encryptedSentence);
    }
    
    @ParameterizedTest
    @ValueSource( strings = {"Alamakota"})
    void testEncryptSentencesFailed(String originalSentence) throws InvalidCharacterException {
        CipherModel cipherModel = new CipherModel(originalSentence);

        String encryptedSentence = cipherModel.encrypt(cipherModel.getOriginalSentence());
        assertNotEquals("Wrong", encryptedSentence);
    }
    
    @ParameterizedTest
    @ValueSource( strings = {"Ala ma kota"})
    void testEncryptSentencesThrows(String originalSentence) throws InvalidCharacterException {
        CipherModel cipherModel = new CipherModel(originalSentence);

        assertThrows(InvalidCharacterException.class, () -> {
            cipherModel.encrypt(cipherModel.getOriginalSentence());
        });
    }
    
    @ParameterizedTest
    @CsvSource( {"Alamakota, Zoznzplgz","qwerty, jdvigb","nic, mrx"})
    void testEncryptListSentencesCorrect(String originalSentence) throws InvalidCharacterException {
//        CipherModel cipherModel = new CipherModel(originalSentence);
//
//        List<String> encryptedSentence = cipherModel.encryptSentences(cipherModel.getOriginalListSentences());
//        assertEquals("Zoznzplgz", encryptedSentence);
    }
    
    @ParameterizedTest
    @CsvSource( {"Alamakota, Wrong","qwerty, Wrong","nic, Wrong"})
    void testEncryptListSentencesFailed(String originalSentence) throws InvalidCharacterException {
//        CipherModel cipherModel = new CipherModel(originalSentence);
//
//        List<String> encryptedSentence = cipherModel.encryptSentences(cipherModel.getOriginalListSentences());
//        assertNotEquals("Wrong", encryptedSentence);
    }
    
    @ParameterizedTest
    @ValueSource( strings = {"Ala ma kota", "qwe rty", "n i c"})
    void testEncryptListSentencesThrows(String originalSentence) throws InvalidCharacterException {
//        CipherModel cipherModel = new CipherModel(originalSentence);
//
//        assertThrows(InvalidCharacterException.class, () -> {
//            cipherModel.encryptSentences(cipherModel.getOriginalListSentences());
//        });
    }
            
    @Test
    void testEncryptCharCorrect(){
        char originalChar = 'a';
        char encryptedChar = CipherModel.encryptChar(originalChar);
        assertEquals('z', encryptedChar);
    }
    @Test
    void testEncryptCharFailed(){
        char originalChar = 'a';
        char encryptedChar = CipherModel.encryptChar(originalChar);
        assertNotEquals('a', encryptedChar);
    }
    @Test
    void testEncryptCharNotLetter(){
        char originalChar = 1;
        char encryptedChar = CipherModel.encryptChar(originalChar);
        assertEquals(1, encryptedChar);
    }

//    @org.junit.jupiter.api.BeforeAll
//    public static void setUpClass() throws Exception {
//    }
//
//    @org.junit.jupiter.api.AfterAll
//    public static void tearDownClass() throws Exception {
//    }
//
//    @org.junit.jupiter.api.BeforeEach
//    public void setUp() throws Exception {
//    }
//
//    @org.junit.jupiter.api.AfterEach
//    public void tearDown() throws Exception {
//    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
