package nano.shangguan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Сô on 2016/4/23.
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        boolean flag = true;
        Arrays.sort(nums);
        List<Integer> p = new ArrayList<Integer>();
        for (int n : nums) p.add(n);
        lists.add(p);
        while (flag) {
            flag = false;
            for (int i = len - 2; i > -1; i--) {
                if (nums[i] < nums[i + 1]) {
                    int copy = nums[i];
                    int j = len - 1;
                    while (nums[j] <= nums[i]) j--;
                    nums[i] = nums[j];
                    nums[j] = copy;
                    Arrays.sort(nums, i + 1, len);
                    p = new ArrayList<Integer>();
                    for (int n : nums) p.add(n);
                    lists.add(p);
                    flag = true;
                    break;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,6,2};
        System.out.println(permute(nums).toString());
    }
}
