package nano.shangguan;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Created by Nano on 2016/1/30.
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        int cnt = 0, i = 0;
        for (long known_sum = 1; known_sum <= n;) {
            if (i < nums.length && nums[i] <= known_sum) {
                known_sum += nums[i++];
            }
            else {
                known_sum <<= 1;
                cnt++;
            }
        }
        return cnt;
    }
}