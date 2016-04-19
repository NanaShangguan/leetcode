package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/4/19.
 */
public class EditDistanceTest extends TestCase {

    public void testMinDistance() throws Exception {
        String word1 = "a1efo3heu2h";
        String word2 = "fc1bbd32ge";
        assertEquals("WA", 0, new EditDistance().minDistance(word1, word2));
    }
}