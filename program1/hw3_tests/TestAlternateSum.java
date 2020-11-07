import il.ac.tau.cs.sw1.hw3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestAlternateSum {
    @Test
    public void testAlternateSum1() {
        int[] arr = {1, -2, 3, 4, 5};
        Assert.assertEquals(7, ArrayUtils.alternateSum(arr));
    }

    @Test
    public void testAlternateSum2() {
        int[] arr = {1, 2, -3, 4, 5};
        Assert.assertEquals(9, ArrayUtils.alternateSum(arr));
    }

    @Test
    public void testAlternateSum3() {
        int[] arr = {};
        Assert.assertEquals(0, ArrayUtils.alternateSum(arr));
    }

    @Test
    public void testAlternateSum4() {
        int[] arr = {-10, -2};
        Assert.assertEquals(0, ArrayUtils.alternateSum(arr));
    }
}
