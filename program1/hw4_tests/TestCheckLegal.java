import il.ac.tau.cs.sw1.ex4.WordPuzzle;
import org.junit.Assert;
import org.junit.Test;

public class TestCheckLegal {
    @Test
    public void testCheckLegalBad1() {
        char[] puzzle = {WordPuzzle.HIDDEN_CHAR, WordPuzzle.HIDDEN_CHAR, WordPuzzle.HIDDEN_CHAR, 'e', WordPuzzle.HIDDEN_CHAR, WordPuzzle.HIDDEN_CHAR};
        Assert.assertFalse(WordPuzzle.checkLegal("queen", puzzle));
    }

    @Test
    public void testCheckLegalBad2() {
        char[] puzzle = {WordPuzzle.HIDDEN_CHAR, WordPuzzle.HIDDEN_CHAR, WordPuzzle.HIDDEN_CHAR, 'e', WordPuzzle.HIDDEN_CHAR};
        Assert.assertFalse(WordPuzzle.checkLegal("queen", puzzle));
    }

    @Test
    public void testCheckLegalBad4() {
        char[] puzzle = {WordPuzzle.HIDDEN_CHAR, WordPuzzle.HIDDEN_CHAR, WordPuzzle.HIDDEN_CHAR, WordPuzzle.HIDDEN_CHAR, WordPuzzle.HIDDEN_CHAR};
        Assert.assertFalse(WordPuzzle.checkLegal("queen", puzzle));
    }

    @Test
    public void testCheckLegalBad5() {
        char[] puzzle = {'q', 'u', 'e', 'e', 'n'};
        Assert.assertFalse(WordPuzzle.checkLegal("queen", puzzle));
    }

    @Test
    public void testCheckLegalGood2() {
        char[] puzzle = {WordPuzzle.HIDDEN_CHAR, WordPuzzle.HIDDEN_CHAR, 'e', 'e', WordPuzzle.HIDDEN_CHAR};
        Assert.assertTrue(WordPuzzle.checkLegal("queen", puzzle));
    }

    @Test
    public void testCheckLegalGood3() {
        char[] puzzle = {WordPuzzle.HIDDEN_CHAR, 'u', WordPuzzle.HIDDEN_CHAR, WordPuzzle.HIDDEN_CHAR, WordPuzzle.HIDDEN_CHAR};
        Assert.assertTrue(WordPuzzle.checkLegal("queen", puzzle));
    }
}
