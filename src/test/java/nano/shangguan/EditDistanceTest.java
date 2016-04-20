package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/4/19.
 */
public class EditDistanceTest extends TestCase {

    public void testMinDistance() throws Exception {
//        "mart"
//        "karma"
        String word1 = "mart";
        String word2 = "karma";
        assertEquals("WA", 3, new EditDistance().minDistance(word1, word2));
    }
}