package nano.shangguan;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Nano on 2015/11/12.
 */
public class LargestNumber {
    /**
     * e.g. [3, 30, 34, 5, 9]
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        //转为Integer数组
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.valueOf(nums[i]);
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                String str1 = o1.toString() + o2.toString();
                String str2 = o2.toString() + o1.toString();

                int len = str1.length();
                for (int i = 0; i < len; i++) {
                    if (str1.charAt(i) != str2.charAt(i)) {
                        return str1.charAt(i) - str2.charAt(i);
                    }
                }
                return 0;
            }
        });
        String largest = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            Integer item = arr[i];
            if (largest.equals("") && item.equals(0)) continue;
            largest += item.toString();
        }
        return largest.equals("") ? "0" : largest;
    }
}
