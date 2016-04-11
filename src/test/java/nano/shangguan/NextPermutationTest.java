package nano.shangguan;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created by Nano on 2016/3/17.
 */
public class NextPermutationTest extends TestCase {

    public void testNextPermutation() throws Exception {
        int[] nums = {1,5,1};
        new NextPermutation().nextPermutation(nums);
        assertEquals("WA", Arrays.toString(new int[]{5, 1, 1}), Arrays.toString(nums));
    }
}