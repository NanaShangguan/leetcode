package nano.shangguan;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Nano on 2015/11/20.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k < 1 || nums.length == 0) return new int[]{};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] max = new int[nums.length - k + 1];
        Integer[] numsObjects = new Integer[nums.length];
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            Integer inbox = new Integer(nums[j]);
            numsObjects[j] = inbox;
            if (priorityQueue.size() < k) priorityQueue.add(inbox);
            else {
                //记录最大值
                max[i++] = priorityQueue.peek();
                //向前滑动一位
                priorityQueue.remove(numsObjects[j - k]);
                priorityQueue.add(inbox);
            }
        }
        max[i] = priorityQueue.peek();
        return max;
    }
}
