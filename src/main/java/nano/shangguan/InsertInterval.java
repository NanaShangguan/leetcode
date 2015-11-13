package nano.shangguan;

import util.Interval;

import java.util.List;

/**
 * Created by Nano on 2015/11/13.
 */
public class InsertInterval {
    /**
     * 1.查询新区间start应有的位置pos，在pos位置插入新区间
     * 2.对pos-1之后的区间进行合并
     * @param intervals
     * @param newInterval
     * @return
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int pos = findPosition(intervals, newInterval);
        intervals.add(pos, newInterval);
        int i = pos;
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) i++;
        if (i != 1) {
            //对[pos-1, i-1]进行合并
            Interval start = newInterval;
            if (pos != 0 && intervals.get(pos - 1).end >= newInterval.start)
                start = intervals.get(pos - 1);
            start.end = Math.max(Math.max(newInterval.end, intervals.get(i - 1).end), start.end);
            //删除被合并的区间
            int deleteIndex = intervals.indexOf(start) + 1;
            for (int j = deleteIndex; j < i; j++)
                intervals.remove(deleteIndex);
        }

        return intervals;
    }

    /**
     * 二分查找
     * @param intervals
     * @param newInterval
     * @return
     */
    public int findPosition(List<Interval> intervals, Interval newInterval) {
        int len = intervals.size();
        int low = 0, high = len - 1;
        int newStart = newInterval.start;
        while (low <= high) {
            int middle_index = (low + high) / 2;
            int middle_start = intervals.get(middle_index).start;
            if (newStart == middle_start) return middle_index;
            else if (newStart < middle_start) high = middle_index - 1;
            else low = middle_index + 1;
        }
        return low;
    }
}
