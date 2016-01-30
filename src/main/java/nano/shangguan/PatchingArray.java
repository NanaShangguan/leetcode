package nano.shangguan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2016/1/30.
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        List<Integer> list = null;
        if (nums.length != 0) list = combinations(nums, 0);
        else list = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++)
            if (list.get(i) > n) list.remove(i);
        int num = 0;
        int patch = 1;
        while (list.size() != n) {
            num++;
            if (!list.contains(patch)) {
                int len = list.size();
                list.add(patch);
                for (int i = 0; i < len && list.size() != n; i++) {
                    Integer newNum = list.get(i) + patch;
                    if (newNum < n) {
                        if (!list.contains(newNum)) list.add(newNum);
                    }
                }
            }
            patch++;
        }
        return num;
    }

    private List<Integer> combinations(int[] nums, int begin) {
        if (begin == nums.length - 1) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[begin]);
            return list;
        } else {
            List<Integer> list = combinations(nums, begin + 1);
            int len = list.size();
            if (!list.contains(nums[begin])) list.add(nums[begin]);
            for (int i = 0; i < len; i++) {
                int newNum = nums[begin] + list.get(i);
                if (!list.contains(newNum)) list.add(newNum);
            }
            return list;
        }
    }
}