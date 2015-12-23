package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2015/12/18.
 */
public class TrappingRainWaterTest extends TestCase {

    public void testTrap() throws Exception {
        int[][] height = new int[][] {
                {0,1,0,2,1,0,1,3,2,1,2,1},
                {5,4,1,2},
                {}
        };
        int[] expected = new int[] {6, 1, 0};

        for (int i = 0; i < height.length; i++) {
            assertEquals("Wrong Answer", expected[i], new TrappingRainWater().trap(height[i]));
        }
    }
}