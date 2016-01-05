package nano.shangguan;

/**
 * Created by Nano on 2016/1/5.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        return max(nums, 0, nums.length - 1);
    }

    private int max(int[] nums, int start, int end) {
        if (start > end) return Integer.MIN_VALUE;
        if (start == end) return nums[start];
        int pivot = (start + end) / 2;
        int leftMax = max(nums, start, pivot - 1);
        int rightMax = max(nums, pivot + 1, end);
        int sum = nums[pivot], max = sum;
        for (int i = pivot - 1; i >= start; i--) {
            sum += nums[i];
            if (max < sum) max = sum;
        }
        sum = max;
        for (int j = pivot + 1; j <= end; j++) {
            sum += nums[j];
            if (max < sum) max = sum;
        }
        return Math.max(leftMax, Math.max(rightMax, max));
    }
}
