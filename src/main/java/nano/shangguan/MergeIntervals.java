package nano.shangguan;

import util.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Nano on 2015/11/11.
 */
public class MergeIntervals {
    /**
     * 先按照起点进行排序，排序之后有重叠的区间一定是相邻的
     * 只要扫描一遍排序之后的数组，即可得出结果
     * for: i from 0 to len - 1
     *      if: next.start <= cur.end
     *          需要合并，新区间的start是cur.start，end是max(next.end, cur.end)
     *      else: i++
     * iterate过程中size会变
     *
     * 快排超时，不稳定，TBD 改成归并排序
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
//        quickSort(intervals, 0, intervals.size() - 1);
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (int i = 0; i < intervals.size() - 1; ) {
            Interval current = intervals.get(i);
            Interval next = intervals.get(i + 1);
            if (next.start <= current.end) {
                current.end = Math.max(current.end, next.end);
                intervals.remove(i + 1);
            } else i++;
        }
        return intervals;
    }

    public void quickSort(List<Interval> intervals, int start, int end) {
        if (start >= end) return;
        int low = start, high = end;
        Interval pivot = intervals.get(start);
        boolean flag = false;
        while (low < high) {
            if (!flag) {
                if (intervals.get(high).start >= pivot.start) high--;
                else {
                    intervals.add(low, intervals.get(high));
                    intervals.remove(low + 1);
                    flag = true;
                }
            } else {
                if (intervals.get(low).start <= pivot.start) low++;
                else {
                    intervals.add(high, intervals.get(low));
                    intervals.remove(high + 1);
                    flag = false;
                }
            }
        }
        intervals.add(low, pivot);
        intervals.remove(low + 1);
        quickSort(intervals, start, low - 1);
        quickSort(intervals, low + 1, end);
    }
}
