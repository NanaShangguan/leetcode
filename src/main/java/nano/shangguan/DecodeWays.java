package nano.shangguan;

/**
 * Created by Nano on 2016/3/10.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        if (s.charAt(0) == '0') dp[1] = 0;
        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 1) != '0') dp[i] = dp[i - 1];
            if (s.charAt(i - 2) != '0') {
                int twoBit = Integer.parseInt(s.substring(i - 2, i));
                if (twoBit <= 26) dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}
