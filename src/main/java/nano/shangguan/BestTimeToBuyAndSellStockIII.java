package nano.shangguan;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Nano on 2016/1/7.
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[] left = new int[len];
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            int profit = prices[i] - min;
            left[i] = Math.max(left[i - 1], profit);
            if (min > prices[i]) min = prices[i];
        }
        int[] right = new int[len];
        right[len - 1] = 0;
        int max = prices[len - 1];
        for (int i = len - 2; i > -1; i--) {
            int profit = max - prices[i];
            right[i] = Math.max(right[i + 1], profit);
            if (max < prices[i]) max = prices[i];
        }

        int maxProfit = 0;
        for (int i = 0; i < len - 1; i++) {
            int profit = left[i] + right[i + 1];
            if (maxProfit < profit) maxProfit = profit;
        }
        if (maxProfit < left[len - 1]) maxProfit = left[len - 1];
        return maxProfit;
    }
}
