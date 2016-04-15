package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/4/12.
 */
public class FourSumTest extends TestCase {

    public void testFourSum() throws Exception {
        int[] nums = {1, 0, -1, 0, -2, 2};
        assertEquals("WA", "[[-2, 0, 1, 2], [-1, 0, 0, 2]]", new FourSum().fourSum(nums, 1).toString());
    }
}