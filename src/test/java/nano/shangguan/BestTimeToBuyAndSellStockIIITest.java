package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/1/7.
 */
public class BestTimeToBuyAndSellStockIIITest extends TestCase {

    public void testMaxProfit() throws Exception {
        int[][] prices = {
                {1,2,3,4},
//                {1,2,4,2,5,7,2,4,9,0}
        };
        int[] expected = {3, 13};
        for (int i = 0; i < prices.length; i++)
            assertEquals("Wrong Answer", expected[i], new BestTimeToBuyAndSellStockIII().maxProfit(prices[i]));
    }
}