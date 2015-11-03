package nano.shangguan;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2015/7/7.
 * 整型数int相加减的溢出问题
 * 差值判断：new BigInteger(nums[i] + "").subtract(new BigInteger(nums[i - 1] + "")).compareTo(new BigInteger("1"))
 * 或者：nums[i] > nums[i - 1] + 1
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<String>();
        int begin_of_range = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] > nums[i - 1] + 1) {
                // 把range add进list
                if (i - 1 == begin_of_range)
                    ranges.add(nums[begin_of_range] + "");
                else ranges.add(nums[begin_of_range] + "->" + nums[i - 1]);
                // 重置begin_of_range
                begin_of_range = i;
            }
        }
        return ranges;
    }

    public static void main(String[] args) {
        System.out.println(new SummaryRanges().summaryRanges(new int[]{-2147483648,-2147483647,2147483647}).toString());
    }
}
