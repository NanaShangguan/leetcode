package nano.shangguan;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created by Nano on 2015/11/20.
 */
public class SlidingWindowMaximumTest extends TestCase {

    public void testMaxSlidingWindow() throws Exception {
        int[] nums = new int[]{  };
        assertEquals("Wrong Answer"
                , Arrays.toString(new int[]{})
                , Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(nums, 0)));
    }
}