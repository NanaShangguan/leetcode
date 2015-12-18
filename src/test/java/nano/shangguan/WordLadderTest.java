package nano.shangguan;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nano on 2015/12/17.
 */
public class WordLadderTest extends TestCase {

    public void testLadderLength() throws Exception {
        String beginWord = "hit";
        String endWord = "egg";
        Set<String> wordList = new HashSet<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        assertEquals("Wrong Answer", 0, new WordLadder().ladderLength(beginWord, endWord, wordList));
    }
}