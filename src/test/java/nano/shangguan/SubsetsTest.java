package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2015/12/23.
 */
public class SubsetsTest extends TestCase {

    public void testSubsets() throws Exception {
        int[] nums = new int[] {4,1,0};
        assertEquals("Wrong Answer", "", new Subsets().subsets(nums).toString());
    }
}