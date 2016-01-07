package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/1/7.
 */
public class BestTimeToBuyAndSellStockWithCooldownTest extends TestCase {

    public void testMaxProfit() throws Exception {
//        []
//        [1]
//        [1,2]
//        [2,1]
//        [1,2,3]
//        [1,2,3,4]
//        [1,2,3,0,2]
//        [1,2,3,0,2,8,3,4,9]
//        [2,8,3,4,9,5,3,7,1]
        int[] prices = new int[]{1,2,3,0,2};
        assertEquals("Wrong Answer", 3, new BestTimeToBuyAndSellStockWithCooldown().maxProfit(prices));
    }
}