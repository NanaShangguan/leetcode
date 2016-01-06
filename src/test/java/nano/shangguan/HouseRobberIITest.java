package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/1/6.
 */
public class HouseRobberIITest extends TestCase {

    public void testRob() throws Exception {
        int[] nums = new int[]{4, 7, 5, 12, 56, 2, 90, 33, 66, 45, 51};
        assertEquals("Wrong Answer", 270, new HouseRobberII().rob(nums));
    }
}