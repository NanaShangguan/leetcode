package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/3/14.
 */
public class NQueensTest extends TestCase {

    public void testSolveNQueens() throws Exception {
        assertEquals("WA", "[[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]", new NQueens().solveNQueens(4).toString());
    }
}