import il.ac.tau.cs.sw1.ex5.BigramModel;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestBuildCount {
    @Test
    public void testBuildCount() throws IOException {
        BigramModel model = new BigramModel();
        String filePath = "resources\\hw5\\all_you_need.txt";
        String[] vocab = model.buildVocabularyIndex(filePath);
        int[][] counts = model.buildCountsArray(filePath, vocab);
        int[][] expected = {
                {3,1,0,0,1},
                {0,0,3,0,0},
                {0,0,0,3,0},
                {0,0,0,0,2},
                {2,1,0,0,0}
        };
        Assert.assertArrayEquals(expected, counts);
    }
}
