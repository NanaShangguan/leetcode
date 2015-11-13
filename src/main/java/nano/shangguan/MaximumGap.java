package nano.shangguan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2015/11/13.
 *
 * 假设有N个元素A到B
 * 那么最大差值不会小于ceiling[(B - A) / (N - 1)]， 根据鸽巢原理
 * 令bucket（桶）的大小len = ceiling[(B - A) / (N - 1)]，则最多会有(B - A) / len + 1个桶
 * 对于数组中的任意整数K，很容易通过算式loc = (K - A) / len找出其桶的位置，然后维护每一个桶的最大值和最小值
 * 由于同一个桶内的元素之间的差值至多为len - 1，因此最终答案不会从同一个桶中选择
 * 对于每一个非空的桶p，找出下一个非空的桶q，则q.min - p.max可能就是备选答案。返回所有这些可能值中的最大值
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        //先遍历一遍找出最大值和最小值
        int min = nums[0], max = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] > max) max = nums[i];
            else if (nums[i] < min) min = nums[i];
        }
        //创建桶，记录每个桶内的最大值和最小值
        List<Integer>[] buckets = new List[len];
        int[] maxNums = new int[len];
        int[] minNums = new int[len];

        int range = max - min + 1;
        int bucketSize = range / len;
        if (bucketSize * len < range) bucketSize++;
        //遍历第二次，入桶，并记录最大值最小值
        for (int num : nums) {
            int index = (num - min) / bucketSize;
            if (buckets[index] == null) buckets[index] = new ArrayList<Integer>();
            buckets[index].add(num);
            if (buckets[index].size() == 1) {
                maxNums[index] = num;
                minNums[index] = num;
            } else if (num > maxNums[index]) maxNums[index] = num;
            else if (num < minNums[index]) minNums[index] = num;
        }
        //遍历桶，求出最大gap
        int maxGap = 0;
        int prev = -1;
        for (int i = 0; i < len; i++) {
            List<Integer> bucket = buckets[i];
            if (bucket != null) {
                if (prev != -1) {
                   if (maxGap < minNums[i] - maxNums[prev])
                       maxGap = minNums[i] - maxNums[prev];
                }
                prev = i;
            }
        }
        return maxGap;
    }
}
