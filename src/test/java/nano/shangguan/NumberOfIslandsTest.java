package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2015/11/26.
 */
public class NumberOfIslandsTest extends TestCase {

    public void testNumIslands() throws Exception {
        char[][] grid = new char[][]{
                {'1', '1', '1'},
                {'1', '0', '1'},
                {'1', '1', '1'}
        };
        assertEquals("Wrong Answer", 1, new NumberOfIslands().numIslands(grid));
    }
}