package nano.shangguan;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Nano on 2015/5/7.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.isEmpty() || !map.containsKey(target - nums[i]))
                map.put(nums[i], i);
            else {
                indices[0] = map.get(target - nums[i]) + 1;
                indices[1] = i + 1;
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        int[] indices = new TwoSum().twoSum(new int[]{3,2,4}, 6);
//        int[] indices = new int[]{-1,2,1,-4};
//        new TwoSum().quickSort(indices);
        for (int each : indices)
            System.out.print(each + " ");
    }
}
