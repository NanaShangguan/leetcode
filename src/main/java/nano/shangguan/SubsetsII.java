package nano.shangguan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Nano on 2015/12/24.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = subsetsInRange(nums, 0, nums.length - 1);
        List<String> distinct = new ArrayList<String>();
        for (int i = 0; i < lists.size(); ) {
            String str = lists.get(i).toString();
            if (distinct.contains(str)) lists.remove(i);
            else {
                distinct.add(str);
                i++;
            }
        }
        return lists;
    }

    private List<List<Integer>> subsetsInRange(int[] nums, int start, int end) {
        if (start > end) {
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            lists.add(new ArrayList<Integer>());
            return lists;
        }
        int value = nums[start];
        List<List<Integer>> lists = subsetsInRange(nums, start + 1, end);
        int len = lists.size();
        for (int i = 0; i < len; i++) {
            List<Integer> newList = new ArrayList<Integer>(lists.get(i));
            //在list中找到nums[start]的位置
            int low = 0, high = newList.size() - 1;
            while (low <= high) {
                int middle = (low + high) / 2;
                if (value == newList.get(middle)) {
                    low = middle;
                    break;
                } else if (value > newList.get(middle)) low = middle + 1;
                else high = middle - 1;
            }
            //low的值就是value应该在的位置
            newList.add(low, value);
            //将新列表插入原lists
            lists.add(newList);
        }
        return lists;
    }

}
