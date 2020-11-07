import il.ac.tau.cs.sw1.hw3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestEditDistance {
    @Test
    public void testEditDistance1() {
        Assert.assertFalse(StringUtils.isEditDistanceOne("dog", "god"));
    }

    @Test
    public void testEditDistance2() {
        Assert.assertTrue(StringUtils.isEditDistanceOne("x", "x"));
    }

    @Test
    public void testEditDistance3() {
        Assert.assertTrue(StringUtils.isEditDistanceOne("main", "man"));
    }

    @Test
    public void testEditDistance4() {
        Assert.assertTrue(StringUtils.isEditDistanceOne("ab", "cab"));
    }

    @Test
    public void testEditDistance5() {
        Assert.assertTrue(StringUtils.isEditDistanceOne("cat", "cam"));
    }

    @Test
    public void testEditDistance6() {
        Assert.assertTrue(StringUtils.isEditDistanceOne("ronen", "roen"));
    }

    @Test
    public void testEditDistance7() {
        Assert.assertTrue(StringUtils.isEditDistanceOne("", ""));
    }

    @Test
    public void testEditDistance8() {
        Assert.assertFalse(StringUtils.isEditDistanceOne("ab", "add"));
    }
}
