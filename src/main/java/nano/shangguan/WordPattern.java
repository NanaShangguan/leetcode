package nano.shangguan;

import java.util.HashMap;

/**
 * Created by Nano on 2015/10/19.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        int len = pattern.length();
        if (len != arr.length) return false;
        HashMap<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < len; i++) {
            char each = pattern.charAt(i);
            String word = arr[i];
            if (!map.containsKey(each) && !map.containsValue(word)) {
                map.put(each, word);
                continue;
            } else if (map.containsKey(each) && map.get(each).equals(word))
                continue;
            return false;
        }
        return true;
    }
}
