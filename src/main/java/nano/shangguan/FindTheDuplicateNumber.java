package nano.shangguan;

import java.util.Arrays;

/**
 * Created by Nano on 2016/2/29.
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }
        return 0;
    }
}
