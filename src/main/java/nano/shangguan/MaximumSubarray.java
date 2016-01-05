package nano.shangguan;

/**
 * Created by Nano on 2016/1/5.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len];
        int[] maxFromLast = new int[len];

        dp[0] = nums[0];
        maxFromLast[0] = nums[0];
        for (int i = 1; i < len; i++) {
            maxFromLast[i] = Math.max(nums[i], maxFromLast[i - 1] + nums[i]);
            if (nums[i] > 0) {
                dp[i] = Math.max(dp[i - 1], maxFromLast[i]);
            } else dp[i] = Math.max(dp[i - 1], nums[i]);
        }
        return dp[len - 1];
    }
}
