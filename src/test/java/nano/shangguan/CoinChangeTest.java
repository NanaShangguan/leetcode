package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2015/12/28.
 */
public class CoinChangeTest extends TestCase {

    public void testCoinChange() throws Exception {
//        assertEquals("Wrong Answer", 3, new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
//        assertEquals("Wrong Answer", -1, new CoinChange().coinChange(new int[]{2}, 3));
//        assertEquals("Wrong Answer", 6, new CoinChange().coinChange(new int[]{2, 4, 5}, 26));
        assertEquals("Wrong Answer", 20, new CoinChange().coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}