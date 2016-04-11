package nano.shangguan;

import java.util.Arrays;

/**
 * Created by Nano on 2016/3/17.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len > 1) {
            if (nums[len - 1] > nums[len - 2]) swap(nums, len - 2, len - 1);
            else {
                int maxIndex = len - 2;
                for (int i = len - 3; i > -1; i--) {
                    if (nums[i] < nums[maxIndex]) {
                        //寻找比nums[i]大的数中最小的
                        Arrays.sort(nums, i + 1, len);
                        int minIndex = i + 1;
                        while (nums[minIndex] <= nums[i]) minIndex++;
                        swap(nums, i, minIndex);
                        return;
                    } else maxIndex = i;
                }
                Arrays.sort(nums);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int copy = nums[i];
        nums[i] = nums[j];
        nums[j] = copy;
    }
}
