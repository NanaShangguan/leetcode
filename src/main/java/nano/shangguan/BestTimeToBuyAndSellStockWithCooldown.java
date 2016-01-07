package nano.shangguan;

/**
 * Created by Nano on 2016/1/6.
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        //动态规划解
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            int notSell = dp[i - 1];
            int sell = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (prices[j] < prices[i]) {
                    //买入
                    int profit = prices[i] - prices[j]
                            + (j - 2 < 0 ? 0 : dp[j - 2]);
                    if (sell < profit) sell = profit;
                }
            }
            dp[i] = Math.max(notSell, sell);
        }
        return dp[len - 1];
    }
}
