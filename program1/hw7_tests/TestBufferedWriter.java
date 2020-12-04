import il.ac.tau.cs.software1.bufferedIO.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;


public class TestBufferedWriter {
    public static final String RESOURCES_FOLDER = "tests/resources/";

    private void compareFiles() throws IOException {
        BufferedReader b1 = new BufferedReader(new FileReader(RESOURCES_FOLDER + "rocky1_out.txt"));
        BufferedReader b2 = new BufferedReader(new FileReader(RESOURCES_FOLDER + "rocky1_correct.txt"));

        String b1Line;
        while ((b1Line = b1.readLine()) != null) {
            assert b2.ready() : b1Line;
            String b2Line = b2.readLine();
            assert b1Line.equals(b2Line) : b1Line + ";" + b2Line;
        }
    }

    private void testSanityBufferSize(int bufferSize) throws IOException {
        String outputFileName = RESOURCES_FOLDER + "rocky1_out.txt";
        String outString1 = "Now somewhere in the Black mining Hills of Dakota\nThere lived a young boy named Rocky Raccoon,\n";
        String outString2 = "And one day his woman";
        String outString3 = " ran off with another guy,\nHit young Rocky in the eye.";
        FileWriter fWriter = new FileWriter(outputFileName);
        IBufferedWriter bW = new MyBufferedWriter(fWriter, bufferSize);
        bW.write(outString1);
        bW.write(outString2);
        bW.write(outString3);
        bW.close();
        compareFiles();
    }

    @Test
    public void testWriter() throws IOException {
        for (int i = 1; i <= 200; i++) {
            testSanityBufferSize(i);
        }
    }

    @Test
    public void testBuffer() throws IOException {
        String outputFileName = RESOURCES_FOLDER + "rocky2_out.txt";
        MyFileWriter fWriter = new MyFileWriter(new File(outputFileName));
        IBufferedWriter bW = new MyBufferedWriter(fWriter, 10);

        bW.write("hello");
        assert fWriter.getWritesCount() == 0;
        bW.write("hell");
        assert fWriter.getWritesCount() == 0;
        bW.write("hell");
        assert fWriter.getWritesCount() == 1;

        bW.close();
    }
}
