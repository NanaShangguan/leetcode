package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/4/21.
 */
public class PermutationsIITest extends TestCase {

    public void testPermuteUnique() throws Exception {
        int[] nums = {3,3,1,2,3,2,3,1};
        assertEquals("WA", "", new PermutationsII().permuteUnique(nums));
    }
}