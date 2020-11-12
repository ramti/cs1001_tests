import il.ac.tau.cs.sw1.ex4.WordPuzzle;
import org.junit.Assert;
import org.junit.Test;

public class TestApplyGuess {
    @Test
    public void testApplyGuess() {
        String solution = "java";
        char[] puzzle = {'_', '_', '_', '_'};

        Assert.assertEquals(1, WordPuzzle.applyGuess('j', solution, puzzle));
        char[] expected1 = {'j', '_', '_', '_'};
        Assert.assertArrayEquals(expected1, puzzle);

        Assert.assertEquals(2, WordPuzzle.applyGuess('a', solution, puzzle));
        char[] expected2 = {'j', 'a', '_', 'a'};
        Assert.assertArrayEquals(expected2, puzzle);

        Assert.assertEquals(1, WordPuzzle.applyGuess('v', solution, puzzle));
        char[] expected3 = {'j', 'a', 'v', 'a'};
        Assert.assertArrayEquals(expected3, puzzle);

        Assert.assertEquals(0, WordPuzzle.applyGuess('v', solution, puzzle));
        char[] expected4 = {'j', 'a', 'v', 'a'};
        Assert.assertArrayEquals(expected4, puzzle);

        Assert.assertEquals(0, WordPuzzle.applyGuess('l', solution, puzzle));
        char[] expected5 = {'j', 'a', 'v', 'a'};
        Assert.assertArrayEquals(expected5, puzzle);
    }
}
