import il.ac.tau.cs.sw1.ex5.BigramModel;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestBuildVocabularyIndex {
    @Test
    public void testBuildVocabularyIndex1() throws IOException {
        BigramModel model = new BigramModel();
        String[] vocab = model.buildVocabularyIndex("resources\\hw5\\all_you_need.txt");
        String[] expected = {"love", "all", "you", "need", "is"};
        Assert.assertArrayEquals(expected, vocab);
    }

    @Test
    public void testBuildVocabularyIndex2() throws IOException {
        BigramModel model = new BigramModel();
        String[] vocab = model.buildVocabularyIndex("tests\\resources\\test1.txt");
        String[] expected = {"love", "some_num", "all", "you", "need", "is"};
        Assert.assertArrayEquals(expected, vocab);
    }
}
