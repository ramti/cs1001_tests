import il.ac.tau.cs.sw1.ex5.BigramModel;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestMostFrequent {
    @Test
    public void testMostFrequent1() throws IOException {
        BigramModel model = new BigramModel();
        model.loadModel("resources\\hw5\\all_you_need_model");
        Assert.assertEquals("love", model.getMostFrequentProceeding("love"));
        Assert.assertEquals("is", model.getMostFrequentProceeding("need"));
        Assert.assertEquals("need", model.getMostFrequentProceeding("you"));
    }

    @Test
    public void testMostFrequent2() throws IOException {
        BigramModel model = new BigramModel();
        model.loadModel("tests\\resources\\test_model");
        Assert.assertNull(null, model.getMostFrequentProceeding("all"));
    }
}
