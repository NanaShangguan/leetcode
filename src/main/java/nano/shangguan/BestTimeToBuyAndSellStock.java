package nano.shangguan;

/**
 * Created by Nano on 2016/1/6.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int min = prices[0], maxProfit = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > min) {
                //卖出
                int profit = prices[i] - min;
                if (maxProfit < profit) maxProfit = profit;
            } else min = prices[i];
        }
        return maxProfit;
    }
}
