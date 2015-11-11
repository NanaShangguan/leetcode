package nano.shangguan;

/**
 * Created by Nano on 2015/11/11.
 */
public class SortColors {
    /**
     * [0, low)值为0
     * [low, i)值为1
     * [i, high]值待定
     * (high, len)值为2
     * @param nums
     */
    public void sortColors(int[] nums) {
        int len = nums.length;
        int low = 0, high = len - 1;
        for (int i = 0; i <= high; ) {
            int num = nums[i];
            if (num == 0) {
                if (i == low) {
                    i++;
                    low++;
                } else {
                    nums[i] = nums[low];
                    nums[low++] = 0;
                }
            } else if (num == 2) {
                nums[i] = nums[high];
                nums[high--] = 2;
            } else i++;
        }
    }
}