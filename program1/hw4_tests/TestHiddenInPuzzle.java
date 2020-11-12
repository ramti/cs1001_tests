import il.ac.tau.cs.sw1.ex4.WordPuzzle;
import org.junit.Assert;
import org.junit.Test;

public class TestHiddenInPuzzle {

    @Test
    public void testHiddenInPuzzle1() {
        // puzzle1 = {_,_,_,e,_,_}
        char[] puzzle = {WordPuzzle.HIDDEN_CHAR, WordPuzzle.HIDDEN_CHAR, WordPuzzle.HIDDEN_CHAR, 'e', WordPuzzle.HIDDEN_CHAR, WordPuzzle.HIDDEN_CHAR};
        Assert.assertEquals(5, WordPuzzle.countHiddenInPuzzle(puzzle));
    }

    @Test
    public void testHiddenInPuzzle2() {
        // puzzle2 = {_,_,e,e,_,_}
        char[] puzzle = {WordPuzzle.HIDDEN_CHAR, WordPuzzle.HIDDEN_CHAR, 'e', 'e', WordPuzzle.HIDDEN_CHAR, WordPuzzle.HIDDEN_CHAR};
        Assert.assertEquals(4, WordPuzzle.countHiddenInPuzzle(puzzle));
    }

    @Test
    public void testHiddenInPuzzle3() {
        // puzzle3 = {w,_,i,_,e}
        char[] puzzle = {'w', WordPuzzle.HIDDEN_CHAR, 'i', WordPuzzle.HIDDEN_CHAR, 'e'};
        Assert.assertEquals(2, WordPuzzle.countHiddenInPuzzle(puzzle));
    }

    @Test
    public void testHiddenInPuzzle4() {
        char[] puzzle = {'w', WordPuzzle.HIDDEN_CHAR, 'e', 'e', WordPuzzle.HIDDEN_CHAR, WordPuzzle.HIDDEN_CHAR};
        Assert.assertEquals(3, WordPuzzle.countHiddenInPuzzle(puzzle));
    }


}
