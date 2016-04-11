package nano.shangguan;

import junit.framework.TestCase;

/**
 * Created by Nano on 2016/3/28.
 */
public class LongestSubstringWithAtMostKDistinctCharactersTest extends TestCase {

    public void testLengthOfLongestSubstringKDistinct() throws Exception {
        assertEquals("WA", 1, new LongestSubstringWithAtMostKDistinctCharacters().lengthOfLongestSubstringKDistinct("aba", 1));
    }
}