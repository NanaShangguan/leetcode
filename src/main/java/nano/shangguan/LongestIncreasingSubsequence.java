package nano.shangguan;


/**
 * Created by Nano on 2016/1/6.
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len];
        int max = 1;
        for (int i = len - 1; i >= 0; i--) {
            int maxLen = 0;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[i]) {
                    if (maxLen < dp[j]) maxLen = dp[j];
                }
            }
            dp[i] = maxLen + 1;
            if (max < dp[i]) max = dp[i];
        }
        return max;
    }
}
