package nano.shangguan;

/**
 * Created by Nano on 2016/1/7.
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[] buy1 = new int[len];
        int[] buy2 = new int[len];
        int[] t1 = new int[len];
        int[] t2 = new int[len];

        buy1[0] = -prices[0];
        buy1[1] = Math.max(-prices[1], buy1[0]);
        t1[1] = prices[1] + buy1[0];
        if (len == 2) return Math.max(0, t1[1]);
        buy2[2] = t1[1] - prices[2];
        t1[2] = Math.max(t1[1], buy1[1] + prices[2]);
        buy1[2] = Math.max(-prices[2], buy1[1]);
        if (len == 3) return Math.max(0, t1[2]);
        t2[3] = buy2[2] + prices[3];
        buy1[3] = Math.max(-prices[3], buy1[2]);
        t1[3] = Math.max(t1[2], buy1[2] + prices[3]);
        buy2[3] = Math.max(buy2[2], t1[2] - prices[3]);

        for (int i = 4; i < len; i++) {
            buy1[i] = Math.max(-prices[i], buy1[i - 1]);
            t1[i] = Math.max(t1[i - 1], buy1[i - 1] + prices[i]);
            buy2[i] = Math.max(buy2[i - 1], t1[i - 1] - prices[i]);
            t2[i] = Math.max(t2[i - 1], buy2[i - 1] + prices[i]);
        }

        return Math.max(0, Math.max(t1[len - 1], t2[len - 1]));
    }
}
