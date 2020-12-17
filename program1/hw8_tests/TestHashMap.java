import org.junit.Test;
import il.ac.tau.cs.sw1.ex8.histogram.*;

import java.util.*;

public class TestHashMap {
    @Test
    public void TestInsertDelete() throws IllegalItemException, IllegalKValueException {
        IHistogram<String> hist = new HashMapHistogram<>();
        hist.addItem("aa");
        assert hist.getCountForItem("aa") == 1;
        hist.removeItem("aa");
        assert hist.getCountForItem("aa") == 0;

        hist.addItemKTimes("aa", 10);
        assert hist.getCountForItem("aa") == 10;
        hist.addItemKTimes("aa", 10);
        assert hist.getCountForItem("aa") == 20;
        hist.removeItem("aa");
        assert hist.getCountForItem("aa") == 19;
        hist.removeItemKTimes("aa", 10);
        assert hist.getCountForItem("aa") == 9;
        hist.removeItemKTimes("aa", 9);
        assert hist.getCountForItem("aa") == 0;
    }

    @Test
    public void TestInsertAll() {
        IHistogram<String> hist = new HashMapHistogram<>();
        hist.addItem("aa");
        hist.addAll(Arrays.asList("aa", "bb", "cc", "dd", "cc", "dd"));
        assert hist.getCountForItem("aa") == 2;
        assert hist.getCountForItem("bb") == 1;
        assert hist.getCountForItem("cc") == 2;
        assert hist.getCountForItem("dd") == 2;
    }


    @Test
    public void TestUpdate() throws IllegalKValueException {
        IHistogram<String> hist = new HashMapHistogram<>();
        hist.addAll(Arrays.asList("aa", "bb", "cc", "dd"));
        hist.addItemKTimes("aa", 10);

        IHistogram<String> hist2 = new HashMapHistogram<>();
        hist2.addAll(Arrays.asList("aa", "bb", "cc", "ff"));
        hist.update(hist2);

        assert hist.getCountForItem("aa") == 12;
        assert hist.getCountForItem("bb") == 2;
        assert hist.getCountForItem("cc") == 2;
        assert hist.getCountForItem("dd") == 1;
        assert hist.getCountForItem("ff") == 1;
    }

    @Test
    public void TestClear() {
        IHistogram<String> hist = new HashMapHistogram<>();
        hist.addAll(Arrays.asList("aa", "bb"));
        hist.clear();

        assert hist.getCountForItem("aa") == 0;
        assert hist.getCountForItem("bb") == 0;
    }

    @Test
    public void TestGetItemSet() {
        IHistogram<String> hist = new HashMapHistogram<>();
        hist.addAll(Arrays.asList("aa", "bb"));

        assert hist.getItemsSet().equals(new HashSet<>(Arrays.asList("aa", "bb")));
        hist.clear();
        assert hist.getItemsSet().equals(new HashSet<>());
    }

    @Test(expected = IllegalItemException.class)
    public void TestIllegalItemException1() throws IllegalItemException {
        IHistogram<String> hist = new HashMapHistogram<>();
        hist.removeItem("aa");
    }

    @Test(expected = IllegalItemException.class)
    public void TestIllegalItemException2() throws IllegalItemException, IllegalKValueException {
        IHistogram<String> hist = new HashMapHistogram<>();
        hist.removeItemKTimes("aa", 10);
    }

    @Test(expected = IllegalKValueException.class)
    public void TestIllegalK1() throws IllegalItemException, IllegalKValueException {
        IHistogram<String> hist = new HashMapHistogram<>();
        hist.addItem("aa");
        hist.removeItemKTimes("aa", 2);
    }

    @Test(expected = IllegalKValueException.class)
    public void TestIllegalK2() throws IllegalItemException, IllegalKValueException {
        IHistogram<String> hist = new HashMapHistogram<>();
        hist.removeItemKTimes("aa", -2);
    }

    @Test
    public void TestIterator() throws IllegalKValueException {
        IHistogram<String> stringHist = new HashMapHistogram<>();
        stringHist.addItemKTimes("bb", 5);
        stringHist.addItemKTimes("aa", 5);
        stringHist.addItem("de");
        stringHist.addItem("de");
        stringHist.addItem("de");
        stringHist.addItem("de");
        stringHist.addItem("abc");
        stringHist.addItem("abc");
        stringHist.addItem("abc");
        stringHist.addItem("a");
        stringHist.addItem("b");

        ArrayList<String> order = new ArrayList<>(Arrays.asList("aa", "bb", "de", "abc", "a", "b"));

        Iterator<String> iterator = stringHist.iterator();
        for (String val : order) {
            assert iterator.hasNext();
            assert iterator.next().equals(val);
        }
        assert !iterator.hasNext();
    }
}
