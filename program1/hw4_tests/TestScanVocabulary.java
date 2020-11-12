import il.ac.tau.cs.sw1.ex4.WordPuzzle;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class TestScanVocabulary {

    @Test
    public void testScanVocabulary1() {
        String vocabularyText = "I look at the floor and I see it needs sweeping while my guitar gently wheeps";
        Scanner vocabularyScanner = new Scanner(vocabularyText);
        String[] vocabulary = WordPuzzle.scanVocabulary(vocabularyScanner);
        String[] expected = {"and", "at", "floor", "gently", "guitar", "it", "look", "my", "needs", "see", "sweeping", "the", "wheeps", "while"};
        Assert.assertArrayEquals(expected, vocabulary);
    }

    @Test
    public void testScanVocabulary2() {
        String vocabularyText = "I R2-D2";
        Scanner vocabularyScanner = new Scanner(vocabularyText);
        String[] vocabulary = WordPuzzle.scanVocabulary(vocabularyScanner);
        String[] expected = {};
        Assert.assertArrayEquals(expected, vocabulary);
    }

    @Test
    public void testScanVocabulary3() {
        String vocabularyText = "I love R2-D2 love JAVA love javA";
        Scanner vocabularyScanner = new Scanner(vocabularyText);
        String[] vocabulary = WordPuzzle.scanVocabulary(vocabularyScanner);
        String[] expected = {"java", "love"};
        Assert.assertArrayEquals(expected, vocabulary);
    }

    @Test
    public void testScanVocabulary4() {
        String[] textParts = new String[3002];
        for (int i = 0; i < textParts.length; i++) {
            StringBuilder sb = new StringBuilder("JAVa");
            for (int j = 0; j < i; j++)
                sb.append('a');
            textParts[i] = sb.toString();
        }
        textParts[2999] = "Lena";
        String vocabularyText = String.join(" ", textParts);

        Scanner vocabularyScanner = new Scanner(vocabularyText);
        String[] vocabulary = WordPuzzle.scanVocabulary(vocabularyScanner);

        String[] expected = new String[3000];
        for (int i = 0; i < expected.length; i++) {
            StringBuilder sb = new StringBuilder("java");
            for (int j = 0; j < i; j++)
                sb.append('a');
            expected[i] = sb.toString();
        }
        expected[2999] = "lena";

        Assert.assertArrayEquals(expected, vocabulary);
    }
}
