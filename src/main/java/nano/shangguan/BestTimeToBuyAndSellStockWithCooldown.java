package nano.shangguan;

/**
 * Created by Nano on 2016/1/6.
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        return helper(prices, 0, prices.length - 1);
    }

    private int helper(int[] prices, int start, int end) {
        int maxPriceIndex = start, len = end - start + 1;
        if (len < 1) return 0;
        for (int i = 1; i < len; i++) {
            int index = start + i;
            if (prices[index] > prices[maxPriceIndex])
                maxPriceIndex = index;
        }
        int maxBuy = maxProfitWithoutCooldown(prices, start, maxPriceIndex)
                + helper(prices, maxPriceIndex + 2, end);
        int maxPrevBuy = maxProfitWithoutCooldown(prices, start, maxPriceIndex - 1)
                + helper(prices, maxPriceIndex + 1, end);
        return Math.max(maxBuy, maxPrevBuy);
    }

    private int maxProfitWithoutCooldown(int[] prices, int start, int end) {
        int len = end - start + 1;
        if (len < 2) return 0;
        int min = prices[start], maxProfit = 0;
        for (int i = 1; i < len; i++) {
            int price = prices[start + i];
            if (price > min) {
                //Âô³ö
                int profit = price - min;
                if (maxProfit < profit) maxProfit = profit;
            } else min = price;
        }
        return maxProfit;
    }
}
