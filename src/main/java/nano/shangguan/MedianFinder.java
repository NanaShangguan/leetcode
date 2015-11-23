package nano.shangguan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2015/11/23.
 * 插入排序的思想
 */
public class MedianFinder {
    private List<Integer> array = new ArrayList<Integer>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        int rightPlace = findPlace(num);
        array.add(rightPlace, num);
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (array.size() % 2 == 1) {
            return array.get(array.size() / 2);
        } else {
            int middleIndex = array.size() / 2;
            int middle1 = array.get(middleIndex - 1);
            int middle2 = array.get(middleIndex);
            return (middle1 + middle2) / 2.0;
        }
    }

    private int findPlace(int num) {
        int low = 0, high = array.size() - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            int middleValue = array.get(middle);
            if (middleValue == num) return middle;
            else if (middleValue < num) low = middle + 1;
            else high = middle - 1;
        }
        return low;
    }
}
