import il.ac.tau.cs.sw1.hw3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestFindPath {
    @Test
    public void testFindPath1() {
        int[][] arr = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        Assert.assertEquals(1, ArrayUtils.findPath(arr, 1, 1, 1));

        Assert.assertEquals(0, ArrayUtils.findPath(arr, 1, 1, 2));
    }

    @Test
    public void testFindPath2() {
        int[][] arr = {{1, 0, 0, 1}, {0, 1, 0, 1}, {0, 0, 1, 0}, {1, 1, 0, 1}};
        Assert.assertEquals(1, ArrayUtils.findPath(arr, 0, 1, 2));
        Assert.assertEquals(1, ArrayUtils.findPath(arr, 1, 0, 2));
        Assert.assertEquals(1, ArrayUtils.findPath(arr, 1, 3, 1));

        Assert.assertEquals(0, ArrayUtils.findPath(arr, 0, 1, 9));
        Assert.assertEquals(0, ArrayUtils.findPath(arr, 0, 1, 1));
        Assert.assertEquals(0, ArrayUtils.findPath(arr, 2, 1, 1));
    }

    @Test
    public void testFindPath3() {
        int[][] arr = {{1, 1, 0}, {0, 1, 1}, {0, 1, 1}};
        Assert.assertEquals(1, ArrayUtils.findPath(arr, 0, 2, 2));
        Assert.assertEquals(1, ArrayUtils.findPath(arr, 2, 1, 1));

        Assert.assertEquals(0, ArrayUtils.findPath(arr, 2, 1, 4));
        Assert.assertEquals(0, ArrayUtils.findPath(arr, 2, 0, 2));
        Assert.assertEquals(0, ArrayUtils.findPath(arr, 2, 0, 3));
    }

    @Test
    public void testFindPath4() {
        int[][] arr = {{1, 0, 0, 1}, {1, 1, 0, 1}, {0, 1, 1, 0}, {1, 1, 0, 1}};
        Assert.assertEquals(1, ArrayUtils.findPath(arr, 0, 1, 2));
        Assert.assertEquals(1, ArrayUtils.findPath(arr, 0, 3, 1));
        Assert.assertEquals(1, ArrayUtils.findPath(arr, 2, 1, 1));
        Assert.assertEquals(1, ArrayUtils.findPath(arr, 2, 0, 2));

        Assert.assertEquals(0, ArrayUtils.findPath(arr, 0, 2, 4));
        Assert.assertEquals(0, ArrayUtils.findPath(arr, 0, 1, 1));
        Assert.assertEquals(0, ArrayUtils.findPath(arr, 0, 1, 3));
        Assert.assertEquals(0, ArrayUtils.findPath(arr, 1, 2, 1));
    }
}
