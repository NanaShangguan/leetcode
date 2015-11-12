package nano.shangguan;

import junit.framework.TestCase;
import org.junit.Test;
import util.Interval;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Nano on 2015/11/11.
 */
public class MergeIntervalsTest extends TestCase {

//    @Test
//    public void testMerge() throws Exception {
//
//    }

    @Test
    public void testQuickSort() throws Exception {
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(2, 6);
        Interval interval3 = new Interval(6, 10);
        Interval interval4 = new Interval(9, 18);
        List<Interval> list = new ArrayList<Interval>();
        list.add(interval1);
        list.add(interval4);
        list.add(interval2);
        list.add(interval3);
        List<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(1, 18));
//        expected.add(interval3);
//        expected.add(interval4);
        new MergeIntervals().merge(list);
        assertEquals("Wrong Answer", list.toString(), expected.toString());
    }
}