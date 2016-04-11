package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/4/11.
 */
public class BestTimeToBuyAndSellStockIITest extends TestCase {

    public void testMaxProfit() throws Exception {
//        int[] prices = { 7,6,5,8,9,9,6,5,2,3,9 };
        int[] prices = { 7,6,5,8,5,2,3,9 };
        assertEquals("WA", 10, new BestTimeToBuyAndSellStockII().maxProfit(prices));
    }
}