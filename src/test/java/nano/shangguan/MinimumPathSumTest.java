package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/1/5.
 */
public class MinimumPathSumTest extends TestCase {

    public void testMinPathSum() throws Exception {
        int[][] matrix = new int[][] {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        assertEquals("Wrong Answer", 13, new MinimumPathSum().minPathSum(matrix));
    }
}