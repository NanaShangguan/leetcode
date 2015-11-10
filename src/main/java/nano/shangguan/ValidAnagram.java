package nano.shangguan;

import java.util.HashMap;

/**
 * Created by Nano on 2015/11/10.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char charOfS = s.charAt(i);
            char charOfT = t.charAt(i);
            if (charOfS != charOfT) {
                if (map.containsKey(charOfS)) {
                    int count = map.get(charOfS);
                    if (count == -1) map.remove(charOfS);
                    else map.put(charOfS, count + 1);
                } else map.put(charOfS, 1);

                if (map.containsKey(charOfT)) {
                    int count = map.get(charOfT);
                    if (count == 1) map.remove(charOfT);
                    else map.put(charOfT, count - 1);
                } else map.put(charOfT, -1);
            }
        }
        return map.isEmpty();
    }
}
