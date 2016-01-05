package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/1/5.
 */
public class NumMatrixTest extends TestCase {

    public void testSumRegion() throws Exception {
        int[][] matrix = new int[][] {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        assertEquals("Wrong Answer", 8, numMatrix.sumRegion(2, 1, 4, 3));
        assertEquals("Wrong Answer", 11, numMatrix.sumRegion(1, 1, 2, 2));
        assertEquals("Wrong Answer", 12, numMatrix.sumRegion(1, 2, 2, 4));
    }
}