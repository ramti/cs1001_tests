import il.ac.tau.cs.sw1.ex5.BigramModel;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestWordCount {
    @Test
    public void testWordCount() throws IOException {
        BigramModel model = new BigramModel();
        model.initModel("tests\\resources\\test2.txt");

        Assert.assertEquals(7, model.getWordCount("love"));
        Assert.assertEquals(4, model.getWordCount("some_num"));
        Assert.assertEquals(3, model.getWordCount("need"));
    }
}
