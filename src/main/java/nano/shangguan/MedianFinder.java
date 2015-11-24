package nano.shangguan;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Nano on 2015/11/23.
 * 两个优先队列，一个大根堆，一个小根堆
 * 大根堆保存前一半元素，小根堆保存后一半元素
 */
public class MedianFinder {
    private PriorityQueue<Integer> queueMax = new PriorityQueue<Integer>(new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    private PriorityQueue<Integer> queueMin = new PriorityQueue<Integer>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        int leftSize = queueMax.size();
        int rightSize = queueMin.size();
        if (leftSize + rightSize == 0) queueMax.add(num);
        else if (leftSize == 1 && rightSize == 0) {
            //初始化
            if (queueMax.peek() >= num) {
                queueMin.add(queueMax.poll());
                queueMax.add(num);
            } else queueMin.add(num);
        } else {
            int max = queueMax.peek();
            int min = queueMin.peek();
            if (leftSize == rightSize) {
                if (num < min) queueMax.add(num);
                else {
                    queueMax.add(queueMin.poll());
                    queueMin.add(num);
                }
            } else {
                if (num > max) queueMin.add(num);
                else {
                    queueMin.add(queueMax.poll());
                    queueMax.add(num);
                }
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        int sumCount = queueMax.size() + queueMin.size();
        if (sumCount % 2 == 1) {
            return queueMax.peek();
        } else {
            int middle1 = queueMax.peek();
            int middle2 = queueMin.peek();
            return (middle1 + middle2) / 2.0;
        }
    }
}
