import il.ac.tau.cs.sw1.ex4.WordPuzzle;
import org.junit.Assert;
import org.junit.Test;

public class TestGetHelp {
    @Test
    public void testGetHelp() {
        String solution = "java";
        char[] puzzle = {'_', '_', '_', '_'};

        WordPuzzle.getHelp(solution, puzzle);
        char[] expected1 = {'j', '_', '_', '_'};
        Assert.assertArrayEquals(expected1, puzzle);

        WordPuzzle.getHelp(solution, puzzle);
        char[] expected2 = {'j', 'a', '_', 'a'};
        Assert.assertArrayEquals(expected2, puzzle);

        WordPuzzle.getHelp(solution, puzzle);
        char[] expected3 = {'j', 'a', 'v', 'a'};
        Assert.assertArrayEquals(expected3, puzzle);

        WordPuzzle.getHelp(solution, puzzle);
        char[] expected4 = {'j', 'a', 'v', 'a'};
        Assert.assertArrayEquals(expected4, puzzle);
    }
}
