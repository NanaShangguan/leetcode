package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/4/13.
 */
public class LetterCombinationsTest extends TestCase {

    public void testLetterCombinations() throws Exception {
        String s = "789";
        assertEquals("WA", "", new LetterCombinations().letterCombinations(s).toString());
    }
}