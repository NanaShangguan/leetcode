package nano.shangguan;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created by Nano on 2015/11/26.
 */
public class SurroundedRegionsTest extends TestCase {

    public void testSolve() throws Exception {
        char[][] board = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}

//                {'O', 'O'},
//                {'O', 'O'}
        };
        char[][] expected = new char[][]{
                {'X','X','X','X'},
                {'X','X','X','X'},
                {'X','X','X','X'},
                {'X','O','X','X'}

//                {'O', 'O'},
//                {'O', 'O'}
        };
        new SurroundedRegions().solve(board);
        String expectedString = "", actualString = "";
        for (char[] row : expected) expectedString += Arrays.toString(row);
        for (char[] row : board) actualString += Arrays.toString(row);
        assertEquals("Wrong Answer", expectedString, actualString);
    }
}