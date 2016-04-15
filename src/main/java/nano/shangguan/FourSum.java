package nano.shangguan;

import java.util.*;

/**
 * Created by Nano on 2016/4/12.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int jStart = i + 1;
                for (int j = jStart; j < len; j++) {
                    if (j == jStart || nums[j] != nums[j - 1]) {
                        int sum = nums[i] + nums[j];
                        List<Integer> pair = new ArrayList<Integer>();
                        pair.add(nums[i]);
                        pair.add(nums[j]);
                        if (map.containsKey(sum)) {
                            List<List<Integer>> list = map.get(sum);
                            list.add(pair);
                        } else {
                            List<List<Integer>> list = new ArrayList<List<Integer>>();
                            list.add(pair);
                            map.put(sum, list);
                        }
                    }
                }
            }
        }
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int key = it.next();
            int left = target - key;
            if (map.containsKey(left)) {
                if (left == key) {
                    List<List<Integer>> list = map.get(key);
                    for (int i = 0; i < list.size(); i++) {
                        for (int j = i + 1; j < list.size(); j++) {
                            List<Integer> four = new ArrayList<Integer>();
                            four.addAll(list.get(i));
                            four.addAll(list.get(j));
                            Collections.sort(four);
                            result.add(four);
                        }
                    }
                } else {
                    List<List<Integer>> list1 = map.get(key);
                    List<List<Integer>> list2 = map.get(left);
                    for (int i = 0; i < list1.size(); i++) {
                        for (int j = 0; j < list2.size(); j++) {
                            List<Integer> four = new ArrayList<Integer>();
                            four.addAll(list1.get(i));
                            four.addAll(list2.get(j));
                            Collections.sort(four);
                            result.add(four);
                        }
                    }
                }
            }
            it.remove();
        }
        return result;
    }
}
