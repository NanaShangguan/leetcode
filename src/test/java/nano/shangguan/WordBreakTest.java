package nano.shangguan;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lenovo on 2016/1/7.
 */
public class WordBreakTest extends TestCase {

    public void testWordBreak() throws Exception {
        String s = "xxxoookkk";
        Set<String> wordDict = new HashSet<String>();
        wordDict.add("xxx");
        wordDict.add("ooo");
        wordDict.add("kkk");
        assertEquals("Wrong Answer", true, new WordBreak().wordBreak(s, wordDict));
    }
}