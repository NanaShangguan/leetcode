package nano.shangguan;

/**
 * Created by Nano on 2016/4/11.
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                sum += (prices[i] - prices[i - 1]);
        }
        return sum;
    }
}
