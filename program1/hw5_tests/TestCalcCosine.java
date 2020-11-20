import il.ac.tau.cs.sw1.ex5.BigramModel;
import org.junit.Assert;
import org.junit.Test;

public class TestCalcCosine {
    @Test
    public void testCalcCosine1() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 0, 5};
        double manualCalc = (1 + 3 * 5) / (Math.sqrt(1 + 2 * 2 + 3 * 3) * Math.sqrt(1 + 5 * 5));
        Assert.assertEquals(manualCalc, BigramModel.calcCosineSim(arr1, arr2), 0.01);
    }

    @Test
    public void testCalcCosine2() {
        int[] arr1 = {0, 0, 0};
        int[] arr2 = {1, 0, 5};
        Assert.assertEquals(-1, BigramModel.calcCosineSim(arr1, arr2), 0.0);
        Assert.assertEquals(-1, BigramModel.calcCosineSim(arr2, arr1), 0.0);
    }
}
