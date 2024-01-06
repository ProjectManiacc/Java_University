/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import model.InvalidCharacterException;
import java.util.List;
import java.util.stream.Stream;
import model.CipherModel;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * JUnit 5 test class for the CipherModel class.
 * 
 * @author piotrek
 * @version 1.2.0
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
            assertEquals("lAmakatoa", encryptedSentence, "Encryption of a single sentence is correct");
        } catch (InvalidCharacterException e) {
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
        try {
            String encryptedSentence = cipherModel.encrypt(cipherModel.getOriginalSentence());
            assertNotEquals("Wrong", encryptedSentence, "Encryption of a single sentence is incorrect");
        } catch (InvalidCharacterException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    /**
     * Test encrypting a sentence containing invalid characters and expecting an exception.
     */
    @ParameterizedTest
    @ValueSource(strings = {"Ala ma kota"})
    @NullSource
    @EmptySource
    void testEncryptSentencesThrows(String originalSentence) {
        CipherModel cipherModel = new CipherModel(originalSentence);

        assertThrows(InvalidCharacterException.class, () -> {
            cipherModel.encrypt(cipherModel.getOriginalSentence());
        }, "Encryption of a single sentence with invalid characters should throw an exception");
    }

    /**
     * Test encrypting a list of sentences and expecting correct results for each.
     */
    @ParameterizedTest
    @MethodSource("provideListSentences")
    void testEncryptListSentencesCorrect(List<String> originalSentences) {
        List<String> expectedEncrypted = List.of("OMYTEL", "UCADIK", "inc");
        CipherModel cipherModel = new CipherModel(originalSentences);
        try {
            List<String> actualEncryptedSentences = cipherModel.encryptSentences(cipherModel.getOriginalListSentences());
            assertEquals(expectedEncrypted, actualEncryptedSentences, "Encryption of a list of sentences is correct");
        } catch (InvalidCharacterException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    /**
     * Test encrypting a list of sentences and expecting a failure (incorrect result) for each.
     */
    @ParameterizedTest
    @MethodSource("provideListSentences")
    void testEncryptListSentencesFailed(List<String> originalSentences) {
        List<String> expectedEncrypted = List.of("Wrong", "Wrong", "Wrong");
        CipherModel cipherModel = new CipherModel(originalSentences);
        try {
            List<String> encryptedSentences = cipherModel.encryptSentences(cipherModel.getOriginalListSentences());
            assertNotEquals("Wrong", encryptedSentences, "Encryption of a list of sentences is incorrect");
        } catch (InvalidCharacterException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    /**
     * Test whether the list is not null for a given set of sentences.
     */
    @ParameterizedTest
    @MethodSource("provideListSentencesNonEmpty")
    void testListNotNull(List<String> originalSentences) {
        CipherModel cipherModel = new CipherModel(originalSentences);

        assertNotNull(cipherModel.getOriginalListSentences(), "The list should not be null");
    }

    /**
     * Test whether the list is not empty for a given set of sentences.
     */
    @ParameterizedTest
    @MethodSource("provideListSentencesNonEmpty")
    void testListNotEmpty(List<String> originalSentences) {
        CipherModel cipherModel = new CipherModel(originalSentences);

        assertFalse(cipherModel.getOriginalListSentences().isEmpty(), "The list should not be empty");
    }

    /**
     * Provides a stream of non-empty lists of sentences for testing.
     */
    private static Stream<List<String>> provideListSentencesNonEmpty() {
        return Stream.of(
                List.of("Item1", "Item2", "Item3"),
                List.of("Left", "Right"),
                List.of("One", "Two", "Three", "Four")
        );
    }

    /**
     * Provides a stream of lists of sentences for testing.
     */
    private static Stream<List<String>> provideListSentences() {
        return Stream.of(List.of("MOTYLE", "CUDAKI", "nic"));
    }

}
