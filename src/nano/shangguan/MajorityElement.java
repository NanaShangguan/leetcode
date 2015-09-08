package nano.shangguan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Nano on 2015/4/30.
 *
 * 排序之后会简单很多
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int each : nums) {
            if (map.containsKey(each))
                map.put(each, map.get(each) + 1);
            else map.put(each, 1);
            if (map.get(each) > nums.length / 2)
                return each;
        }

        return 0;
    }

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{1,1,1,1,2,2,2}));
    }
}
