import org.junit.Assert;
import org.junit.Test;
import il.ac.tau.cs.sw1.hw3.*;

public class TestTransposeMatrix {
    @Test
    public void testTransposeMatrix1() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[][] res = ArrayUtils.transposeMatrix(arr);
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testTransposeMatrix2() {
        int[][] arr = {{-1, 8}, {7, -3}};
        int[][] expected = {{-1, 7}, {8, -3}};
        int[][] res = ArrayUtils.transposeMatrix(arr);
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testTransposeMatrix3() {
        int[][] arr = {{5, 3, 2}};
        int[][] expected = {{5}, {3}, {2}};
        int[][] res = ArrayUtils.transposeMatrix(arr);
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testTransposeMatrix4() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}};
        int[][] expected = {{1, 4}, {2, 5}, {3, 6}};
        int[][] res = ArrayUtils.transposeMatrix(arr);
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testTransposeMatrix5() {
        int[][] arr = {};
        int[][] expected = {};
        int[][] res = ArrayUtils.transposeMatrix(arr);
        Assert.assertArrayEquals(expected, res);
    }
}
