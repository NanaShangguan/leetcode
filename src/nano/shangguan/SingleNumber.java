package nano.shangguan;

/**
 * Created by Nano on 2015/7/15.
 */
public class SingleNumber {
    /**
     * 异或
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            nums[i] = nums[i] ^ nums[i - 1];
        }
        return nums[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1}));
    }
}
