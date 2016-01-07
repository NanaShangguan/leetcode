package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/1/7.
 */
public class BestTimeToBuyAndSellStockIIITest extends TestCase {

    public void testMaxProfit() throws Exception {
        int[] prices = new int[]{1,2,3,4};
        assertEquals("Wrong Answer", 3, new BestTimeToBuyAndSellStockIII().maxProfit(prices));
    }
}