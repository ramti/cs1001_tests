import il.ac.tau.cs.sw1.hw3.ArrayUtils;
import il.ac.tau.cs.sw1.hw3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestSortedSequence {
    @Test
    public void testSortedSequence1() {
        Assert.assertEquals("not to", StringUtils.findSortedSequence("to be or not to be"));
    }

    @Test
    public void testSortedSequence2() {
        Assert.assertEquals("an empty zoo", StringUtils.findSortedSequence("my mind is an empty zoo"));
    }

    @Test
    public void testSortedSequence3() {
        Assert.assertEquals("", StringUtils.findSortedSequence(""));
    }

    @Test
    public void testSortedSequence4() {
        Assert.assertEquals("andy bought candy", StringUtils.findSortedSequence("andy bought candy"));
    }

    @Test
    public void testSortedSequence5() {
        Assert.assertEquals("is not not not", StringUtils.findSortedSequence("life is not not not fair"));
    }

    @Test
    public void testSortedSequence6() {
        Assert.assertEquals("act", StringUtils.findSortedSequence("art act"));
    }

    @Test
    public void testSortedSequence7() {
        Assert.assertEquals("", StringUtils.findSortedSequence("      "));
    }

    @Test
    public void testSortedSequence8() {
        Assert.assertEquals("is not not not", StringUtils.findSortedSequence("life is not not not fair andy bought candy"));
    }

    @Test
    public void testSortedSequence9() {
        Assert.assertEquals("is not not not", StringUtils.findSortedSequence("andy bought candy a life is not not not fair"));
    }

    @Test
    public void testSortedSequence10() {
        Assert.assertEquals("life life life life", StringUtils.findSortedSequence("life life life life"));
    }
}
