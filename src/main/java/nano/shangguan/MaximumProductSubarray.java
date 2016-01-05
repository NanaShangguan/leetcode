package nano.shangguan;

/**
 * Created by Nano on 2016/1/5.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len];
        int[] max = new int[len];
        int[] min = new int[len];
        dp[0] = nums[0];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] < 0) {
                max[i] = nums[i] * min[i - 1];
                min[i] = Math.min(nums[i], nums[i] * max[i - 1]);
            } else if (nums[i] > 0) {
                max[i] = Math.max(nums[i], nums[i] * max[i - 1]);
                min[i] = Math.min(nums[i], nums[i] * min[i - 1]);
            }
            dp[i] = Math.max(max[i], dp[i - 1]);
        }
        return dp[len - 1];
    }
}
