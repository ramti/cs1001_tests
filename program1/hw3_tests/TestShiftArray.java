import il.ac.tau.cs.sw1.hw3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestShiftArray {
    @Test
    public void testShiftArray1() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {2, 3, 4, 5, 1};
        int[] res = ArrayUtils.shiftArrayCyclic(arr, -1, 'R');
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testShiftArray2() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {5, 1, 2, 3, 4};
        int[] res = ArrayUtils.shiftArrayCyclic(arr, 1, 'R');
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testShiftArray3() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        int[] res = ArrayUtils.shiftArrayCyclic(arr, 1, 'r');
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testShiftArray4() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        int[] res = ArrayUtils.shiftArrayCyclic(arr, -2, 'g');
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testShiftArray5() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {4, 5, 1, 2, 3};
        int[] res = ArrayUtils.shiftArrayCyclic(arr, 3, 'L');
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testShiftArray6() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {3, 4, 5, 1, 2};
        int[] res = ArrayUtils.shiftArrayCyclic(arr, -3, 'L');
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testShiftArray7() {
        int[] arr = {0, 8, 9, 5, 6};
        int[] expected = {8, 9, 5, 6, 0};
        int[] res = ArrayUtils.shiftArrayCyclic(arr, -1, 'R');
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testShiftArray8() {
        int[] arr = {};
        int[] expected = {};
        int[] res = ArrayUtils.shiftArrayCyclic(arr, 3, 'R');
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testShiftArray9() {
        int[] arr = {0, 8, 9, 5, 6};
        int[] expected = {0, 8, 9, 5, 6};
        int[] res = ArrayUtils.shiftArrayCyclic(arr, 5, 'R');
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void testShiftArray10() {
        int[] arr = {0, 8, 9, 5, 6};
        int[] expected = {0, 8, 9, 5, 6};
        int[] res = ArrayUtils.shiftArrayCyclic(arr, -10, 'L');
        Assert.assertArrayEquals(expected, res);
    }
}
