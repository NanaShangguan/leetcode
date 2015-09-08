package nano.shangguan;


/**
 * Created by Nano on 2015/4/29.
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (k >= nums.length)
            k = k % nums.length;

        if (k == 0)
            return;

        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int tmp;
        int middle = (start + end + 1) / 2;
        for (int i = start; i < middle; i++) {
            tmp = nums[i];
            nums[i] = nums[end - (i - start)];
            nums[end - (i - start)] = tmp;
        }
    }

    public static void main (String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotate(nums, 3);
        for (int each : nums)
            System.out.print(each + " ");
    }
}
