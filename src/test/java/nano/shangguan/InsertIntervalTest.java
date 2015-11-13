package nano.shangguan;

import junit.framework.TestCase;
import util.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2015/11/13.
 */
public class InsertIntervalTest extends TestCase {

    public void testInsert() throws Exception {
        Interval interval1 = new Interval(1, 2);
        Interval interval2 = new Interval(6, 9);
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(interval1);
        intervals.add(interval2);
        Interval newInterval = new Interval(2, 6);
        assertEquals("Wrong Answer", "[[1, 9]]", new InsertInterval().insert(intervals, newInterval).toString());
    }
}