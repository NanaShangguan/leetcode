package nano.shangguan;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Nano on 2015/11/12.
 */
@RunWith(Parameterized.class)
public class LargestNumberTest extends TestCase {

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {new int[]{ 3, 30, 34, 5, 9 }, "9534330"},
                {new int[]{ 31, 3, 30, 34, 312, 9, 39, 315, 44 }, "944393433153131230"},
                {new int[]{ 128, 12 }, "12812"},
                {new int[]{ 12,121 }, "12121"},
                {new int[]{ 0, 0 }, "0"},
                {new int[]{ 1,2,3,4,5,6,7,8,9,0 }, "9876543210"}
        });
    }

    private int[] nums;
    private String expected;
    public LargestNumberTest(int[] nums, String expected) {
        this.nums = nums;
        this.expected = expected;
    }

    @Test
    public void testLargestNumber() throws Exception {
        assertEquals("Wrong Answer", expected, new LargestNumber().largestNumber(nums));
    }
}