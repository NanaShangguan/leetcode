package nano.shangguan;

import java.util.Arrays;

/**
 * Created by Nano on 2015/12/28.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        //先对coins数组排序
        Arrays.sort(coins);
        //回溯法
        return helper(coins, coins.length - 1, amount);
    }

    private int helper(int[] coins, int end, int amount) {
        int maxCoin = coins[end];
        if (amount % maxCoin == 0) return amount / maxCoin;
        if (end == 0) return -1;
        int maxMultiples = amount / maxCoin;
        int min = -1;
        for (int i = maxMultiples; i >= 0; i--) {
            int result = helper(coins, end - 1, amount - i * maxCoin);
            if (result != -1) {
                int currentNum = result + i;
                if (min == -1 || min > currentNum) min = currentNum;
            }
        }
        return min;
    }
}
