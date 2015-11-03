package nano.shangguan;

import java.util.HashMap;

/**
 * Created by Nano on 2015/6/11.
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return false;
        boolean whether = false;
        HashMap map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.size() < k) {
                if (map.size() != 0 && map.containsKey(nums[i]))
                    return true;
                else map.put(nums[i], i);
            } else {
                // map.size() == k
                if (map.containsKey(nums[i]))
                    return true;
                else {
                    map.remove(nums[i - k]);
                    map.put(nums[i], i);
                }
            }
        }
        return whether;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        int k = 1;
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(nums, k));
    }
}
