package nano.shangguan;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2015/12/16.
 */
public class TriangleTest extends TestCase {

    public void testMinimumTotal() throws Exception {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
//        lists.add(Arrays.asList(new Integer[]{2}));
//        lists.add(Arrays.asList(new Integer[]{3,4}));
//        lists.add(Arrays.asList(new Integer[]{6,5,7}));
//        lists.add(Arrays.asList(new Integer[]{4,1,8,3}));
        assertEquals("Wrong Answer", 0, new Triangle().minimumTotal(lists));
    }
}