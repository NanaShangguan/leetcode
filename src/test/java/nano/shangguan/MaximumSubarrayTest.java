package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/1/5.
 */
public class MaximumSubarrayTest extends TestCase {

    public void testMaxSubArray() throws Exception {
        int[] arr = new int[]{-2,-1};
        assertEquals("Wrong Answer", -1, new MaximumSubarray().maxSubArray(arr));
    }
}