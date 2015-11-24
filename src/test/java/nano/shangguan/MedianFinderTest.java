package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2015/11/23.
 */
public class MedianFinderTest extends TestCase {

    public void testFindMedian() throws Exception {
        MedianFinder finder = new MedianFinder();
        finder.addNum(-1);
//        assertEquals("Wrong Answer", 3.0, finder.findMedian());
        finder.addNum(-2);
//        assertEquals("Wrong Answer", 2.0, finder.findMedian());
        finder.addNum(-3);
        finder.addNum(-4);
        finder.addNum(-5);
        assertEquals("Wrong Answer", -3.0, finder.findMedian());
    }
}