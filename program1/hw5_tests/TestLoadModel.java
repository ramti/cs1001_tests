import il.ac.tau.cs.sw1.ex5.BigramModel;
import org.junit.Test;

import java.io.IOException;

public class TestLoadModel {
    @Test
    public void testSaveModel() throws IOException {
        BigramModel model = new BigramModel();
        String filePath = "resources\\hw5\\all_you_need.txt";
        model.initModel(filePath);

        String outputFilePath = "out_files\\all_you_need";
        model.loadModel(outputFilePath);
    }
}
