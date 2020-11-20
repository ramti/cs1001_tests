import il.ac.tau.cs.sw1.ex5.BigramModel;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestSaveModel {
    @Test
    public void testSaveModel() throws IOException {
        BigramModel model = new BigramModel();
        String filePath = "resources\\hw5\\all_you_need.txt";
        model.initModel(filePath);

        Files.createDirectories(Paths.get("out_files"));
        String outputFilePath = "out_files\\all_you_need";
        model.saveModel(outputFilePath);
    }
}
