import il.ac.tau.cs.sw1.hw6.SectionB;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class TestSectionB {
    @Test
    public void testContains() {
        int[] arr = new int[]{1, 5, 0};
        Assert.assertTrue(SectionB.contains(arr, 5));
        Assert.assertFalse(SectionB.contains(arr, -5));
    }

    @Test
    public void testMax() {
        int[] arr = new int[]{1, -555, 0};
        Assert.assertTrue(SectionB.max(arr) > 1);
    }

    @Test
    public void testMin() {
        int[] arr = new int[]{1, -555, 0};
        int[] arrCopy = new int[arr.length];
        System.arraycopy(arr, 0, arrCopy, 0, arr.length);

        Assert.assertTrue(SectionB.min(arr) <= -555);
        Assert.assertArrayEquals(arr, arrCopy);
    }

    @Test
    public void testReverse() {
        String str = "hello";
        Assert.assertEquals("olleh", SectionB.reverse("hello"));
    }

    @Test
    public void testGuess() {
        int[] arr = {1, 1, 1, 1, 1, 2};
        int[] arrSorted = new int[arr.length];
        System.arraycopy(arr, 0, arrSorted, 0, arr.length);
        Arrays.sort(arrSorted);

        int[] result = SectionB.guess(arr);
        int[] resultSorted = new int[result.length];
        System.arraycopy(result, 0, resultSorted, 0, result.length);
        Arrays.sort(resultSorted);
        Assert.assertFalse(Arrays.equals(result, resultSorted));

        // check if the arrays contains the same elements
        Assert.assertArrayEquals(arrSorted, resultSorted);
    }
}
