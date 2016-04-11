package nano.shangguan;

/**
 * Created by Nano on 2016/4/5.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        //当前所能到达的最远的index
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if (max >= len - 1) return true;
            if (max < i) return false;
            else max = Math.max(i + nums[i], max);
        }
        return true;
    }
}
