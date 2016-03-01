package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/3/1.
 */
public class FindMinimumInRotatedSortedArrayIITest extends TestCase {

    public void testFindMin() throws Exception {
        int[][] nums = {
//                { 1,1,3 },
//                { 3,3,3,1 },
//                {0,1,1,1,2,2},
                {1,1}
        };
        int[] expect = {1,1,0};
//        int[] nums = { 1,1,3 };
//        int[] nums = { 3,3,3,1 };
//        int[] nums = {0,1,1,1,2,2};
        for (int i = 0; i < nums.length; i++) {
            assertEquals("Wrong Answer", expect[i], new FindMinimumInRotatedSortedArrayII().findMin(nums[i]));
        }
    }
}