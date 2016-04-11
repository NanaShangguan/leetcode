package nano.shangguan;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Nano on 2016/3/28.
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k < 1) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int distinctCount = 0, seqStart = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean exist = map.containsKey(c);
            map.put(c, i);
            if (!exist) {
                if (distinctCount == k) {
                    //需要删除一个字符
                    int delete = i;
                    char deleteChar = c;
                    Iterator<Character> iterator = map.keySet().iterator();
                    while (iterator.hasNext()) {
                        char key = iterator.next();
                        int index = map.get(key);
                        if (index < delete) {
                            delete = index;
                            deleteChar = key;
                        }
                    }
                    seqStart = delete + 1;
                    map.remove(deleteChar);
                } else distinctCount++;
            }
            int newLen = i - seqStart + 1;
            if (newLen > maxLen) maxLen = newLen;
        }
        return maxLen;
    }
}
