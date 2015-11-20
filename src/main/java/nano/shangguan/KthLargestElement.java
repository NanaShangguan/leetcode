package nano.shangguan;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Nano on 2015/11/19.
 */
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
