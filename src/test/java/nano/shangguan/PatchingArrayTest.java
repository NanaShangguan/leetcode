package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/1/30.
 */
public class PatchingArrayTest extends TestCase {

    public void testMinPatches() throws Exception {
        int[] nums = {1,2,31,33};
        int n = 2147483647;
        assertEquals("Wrong Answer", 28, new PatchingArray().minPatches(nums, n));
    }
}