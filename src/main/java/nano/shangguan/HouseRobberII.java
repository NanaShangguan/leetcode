package nano.shangguan;


/**
 * Created by Nano on 2016/1/6.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len < 4) {
            int max = nums[0];
            for (int i = 1; i < len; i++)
                if (max < nums[i]) max = nums[i];
            return max;
        }
        int robFirst = helper(nums, 2, len - 2) + nums[0];
        int robLast = helper(nums, 1, len - 3) + nums[len - 1];
        int robNone = helper(nums, 1, len - 2);
        return Math.max(robFirst, Math.max(robLast, robNone));
    }

    private int helper(int[] nums, int start, int end) {
        if (start > end) return 0;
        int len = end - start + 1;
        int[] dp = new int[len + 1];
        dp[1] = nums[start];
        for (int i = start + 1; i <= end; i++) {
            int index = i - start + 1;
            dp[index] = Math.max(dp[index - 1], dp[index - 2] + nums[i]);
        }
        return dp[len];
    }
}
