package nano.shangguan;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nano on 2015/11/24.
 */
public class TheSkylineProblemTest extends TestCase {

    public void testGetSkyline() throws Exception {
        int[][] buildings = new int[][] {
                {2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}
//                {0,2,3}, {2,5,3}
        };
        int[][] expected = new int[][] {
                {2,10}, {3,15}, {7,12}, {12,0}, {15,10}, {20,8}, {24,0}
        };
        List<int[]> actual = new TheSkylineProblem().getSkyline(buildings);
        String expectedString = "", actualString = "";
        for (int[] each : expected) expectedString += Arrays.toString(each);
        for (int[] each : actual) actualString += Arrays.toString(each);
        assertEquals("Wrong Answer", expectedString, actualString);
    }
}