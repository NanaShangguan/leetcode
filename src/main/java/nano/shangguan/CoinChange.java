package nano.shangguan;


/**
 * Created by Nano on 2015/12/28.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) return 0;
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            if (dp[i] != 1) {
                int min = -1;
                for (int coin : coins) {
                    if (i == coin) {
                        min = 1;
                        break;
                    } else if (i > coin && dp[i - coin] != -1) {
                        int count = dp[i - coin] + 1;
                        if (min == -1 || min > count) min = count;
                    }
                }
                dp[i] = min;
            }
        }
        return dp[amount];
    }
}
