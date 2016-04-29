package nano.shangguan;

import java.util.*;

/**
 * Created by Nano on 2016/4/21.
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        helper(nums, 0, lists);
        return lists;
    }

    void helper(int[] nums, int from, List<List<Integer>> lists) {
        if (from == nums.length - 1) {
            //add to list
            ArrayList<Integer> p = new ArrayList<Integer>();
            for (int num : nums) p.add(num);
            lists.add(p);
            return;
        }
        for (int i = from; i < nums.length; ) {
            swap(nums, from, i);
            helper(nums, from + 1, lists);
            swap(nums, from, i);
            i++;
            while (i < nums.length && nums[i] == nums[i - 1]) i++;
        }

    }
    void swap(int[] nums, int i, int j) {
        int copy = nums[i];
        nums[i] = nums[j];
        nums[j] = copy;
    }
}
