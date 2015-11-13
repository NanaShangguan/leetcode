package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2015/11/13.
 */
public class MaximumGapTest extends TestCase {

    public void testMaximumGap() throws Exception {
        int[] nums = new int[]{ 1, 1, 5, 10, 67, 2, 3, 5, 1, 4, 12, 2 };
        assertEquals("Wrong Answer", 55, new MaximumGap().maximumGap(nums));
    }
}