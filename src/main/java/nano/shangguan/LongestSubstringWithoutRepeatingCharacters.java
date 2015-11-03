package nano.shangguan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Nano on 2015/7/15.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * list维持一段连续的不重复的(字符 => index)
     * 求遍历过程中list的最大值
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) return 0;
        ArrayList<Character> list = new ArrayList<Character>();
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                // 记录list最大size
                if (maxLen < list.size())
                    maxLen = list.size();
                // 弹出重复字符之前的所有字符，包括它自己
                int index = list.indexOf(s.charAt(i));
                for (int j = 0; j <= index; j++)
                    list.remove(0);
                // 把当前字符加入list
                list.add(s.charAt(i));
            } else list.add(s.charAt(i));
        }

        return maxLen < list.size() ? list.size() : maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
    }
}
