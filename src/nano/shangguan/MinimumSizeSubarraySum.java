package nano.shangguan;

/**
 * Created by Nano on 2015/10/13.
 */
public class MinimumSizeSubarraySum {
    /**
     * »¬¶¯´°¿Ú
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int min = len + 1, sum = nums[0];
        for (int front = 0, back = 0; back < len; ) {
            if (sum >= s) {
                int length = back - front + 1;
                if (min > length) min = length;
                if (sum > s) {
                    sum -= nums[front];
                    front++;
                } else {
                    back++;
                    if (back < len) sum += nums[back];
                }
            } else {
                back++;
                if (back < len) sum += nums[back];
            }
        }
        return min == len + 1 ? 0 : min;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(
                11, new int[]{1, 2, 3, 4, 5}
        ));
    }
}
