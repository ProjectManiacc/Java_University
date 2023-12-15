/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import model.InvalidCharacterException;
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
 * JUnit 5 test class for the CipherModel class.
 * 
 * @author piotrek
 */
public class TestCipherModel {

    /**
     * Test encrypting a single sentence and expecting the correct result.
     */
    @ParameterizedTest
    @ValueSource(strings = {"Alamakota"})
    void testEncryptSentencesCorrect(String originalSentence) {
        CipherModel cipherModel = new CipherModel(originalSentence);
        try {
        String encryptedSentence = cipherModel.encrypt(cipherModel.getOriginalSentence());
        assertEquals("Zoznzplgz", encryptedSentence);
        } catch(InvalidCharacterException e){
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    /**
     * Test encrypting a single sentence and expecting a failure (incorrect result).
     */
    @ParameterizedTest
    @ValueSource(strings = {"Alamakota"})
    void testEncryptSentencesFailed(String originalSentence) {
        CipherModel cipherModel = new CipherModel(originalSentence);
        try{
            String encryptedSentence = cipherModel.encrypt(cipherModel.getOriginalSentence());
            assertNotEquals("Wrong", encryptedSentence);
        } catch(InvalidCharacterException e){
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    /**
     * Test encrypting a sentence containing invalid characters and expecting an exception.
     */
    @ParameterizedTest
    @ValueSource(strings = {"Ala ma kota"})
    void testEncryptSentencesThrows(String originalSentence) {
        CipherModel cipherModel = new CipherModel(originalSentence);

        assertThrows(InvalidCharacterException.class, () -> {
            cipherModel.encrypt(cipherModel.getOriginalSentence());
        });
    }

    /**
     * Test encrypting a list of sentences and expecting correct results for each.
     */
    @ParameterizedTest
    @CsvSource({"Alamakota, Zoznzplgz", "qwerty, jdvigb", "nic, mrx"})
    void testEncryptListSentencesCorrect(String originalSentence)  {
        // Uncomment when the method is implemented
        // CipherModel cipherModel = new CipherModel(originalSentence);
        // try{
        // List<String> encryptedSentence = cipherModel.encryptSentences(cipherModel.getOriginalListSentences());
        // assertEquals("Zoznzplgz", encryptedSentence);
        //} catch(InvalidCharacterException e) {
        //    fail("Unexpected exception: " + e.getMessage());
        //}
    }

    /**
     * Test encrypting a list of sentences and expecting a failure (incorrect result) for each.
     */
    @ParameterizedTest
    @CsvSource({"Alamakota, Wrong", "qwerty, Wrong", "nic, Wrong"})
    void testEncryptListSentencesFailed(String originalSentence) {
        // Uncomment when the method is implemented
        // CipherModel cipherModel = new CipherModel(originalSentence);
        // try{
        // List<String> encryptedSentence = cipherModel.encryptSentences(cipherModel.getOriginalListSentences());
        // assertNotEquals("Wrong", encryptedSentence);
        //} catch(InvalidCharacterException e)
        //fail("Unexpected exception: " + e.getMessage());
        //}
    }

    /**
     * Test encrypting a list of sentences containing invalid characters and expecting an exception for each.
     */
    @ParameterizedTest
    @ValueSource(strings = {"Ala ma kota", "qwe rty", "n i c"})
    void testEncryptListSentencesThrows(String originalSentence) throws InvalidCharacterException {
        // Uncomment when the method is implemented
        // CipherModel cipherModel = new CipherModel(originalSentence);
        // try{
        // assertThrows(InvalidCharacterException.class, () -> {
        //    cipherModel.encryptSentences(cipherModel.getOriginalListSentences());
        // });
        //} catch(InvalidCharacterException e){
        // fail("Unexpected exception: " + e.getMessage());
        //}
    }

//    /**
//     * Test encrypting a single character and expecting the correct result.
//     */
//    @Test
//    void testEncryptCharCorrect() {
//        char originalChar = 'a';
//        char encryptedChar = CipherModel.encryptChar(originalChar);
//        assertEquals('z', encryptedChar);
//    }
//
//    /**
//     * Test encrypting a single character and expecting a failure (incorrect result).
//     */
//    @Test
//    void testEncryptCharFailed() {
//        char originalChar = 'a';
//        char encryptedChar = CipherModel.encryptChar(originalChar);
//        assertNotEquals('a', encryptedChar);
//    }
//
//    /**
//     * Test encrypting a non-alphabetic character and expecting it to remain unchanged.
//     */
//    @Test
//    void testEncryptCharNotLetter() {
//        char originalChar = 1;
//        char encryptedChar = CipherModel.encryptChar(originalChar);
//        assertEquals(1, encryptedChar);
//    }
}
