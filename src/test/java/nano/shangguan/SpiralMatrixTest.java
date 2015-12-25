package nano.shangguan;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created by Nano on 2015/12/25.
 */
public class SpiralMatrixTest extends TestCase {

    public void testSpiralOrder() throws Exception {
        int[][] matrix = new int[][] {
                {1},
                {4},
                {7}
        };
        int[] expected = new int[]{1, 4, 7};
        assertEquals("Wrong Answer", Arrays.toString(expected), new SpiralMatrix().spiralOrder(matrix).toString());
    }
}