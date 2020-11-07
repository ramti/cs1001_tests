import il.ac.tau.cs.sw1.hw3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestAnagram {
    @Test
    public void testAnagram1() {
        Assert.assertTrue(StringUtils.isAnagram("mothEr in law", "hitlEr woman"));
    }

    @Test
    public void testAnagram2() {
        Assert.assertTrue(StringUtils.isAnagram("ListeN", "SileNt"));
    }

    @Test
    public void testAnagram3() {
        Assert.assertFalse(StringUtils.isAnagram("software", "jeans"));
    }

    @Test
    public void testAnagram4() {
        Assert.assertTrue(StringUtils.isAnagram("Funeral", "real Fun"));
    }

    @Test
    public void testAnagram5() {
        Assert.assertTrue(StringUtils.isAnagram("Aa", "aA"));
    }

    @Test
    public void testAnagram6() {
        Assert.assertTrue(StringUtils.isAnagram("", " "));
    }
}
