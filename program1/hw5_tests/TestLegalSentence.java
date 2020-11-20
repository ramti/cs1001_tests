import il.ac.tau.cs.sw1.ex5.BigramModel;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestLegalSentence {
    @Test
    public void testLegalSentence() throws IOException {
        BigramModel model = new BigramModel();
        model.loadModel("resources\\hw5\\all_you_need_model");

        Assert.assertTrue(model.isLegalSentence("love all you"));
        Assert.assertTrue(model.isLegalSentence("love"));
        Assert.assertTrue(model.isLegalSentence(""));
        Assert.assertFalse(model.isLegalSentence("love is is"));
        Assert.assertFalse(model.isLegalSentence("love the beatles"));
        Assert.assertFalse(model.isLegalSentence("beatles"));
    }
}
