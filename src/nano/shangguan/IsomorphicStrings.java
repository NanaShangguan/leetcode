package nano.shangguan;

import java.util.HashMap;

/**
 * Created by Nano on 2015/7/15.
 */
public class IsomorphicStrings {
    /**
     * 时间复杂度为O(n)，空间为O(n)
     * 相应位置上的字符组成一对一映射
     * Test Case:
     * 多对一: "ab", "aa"  同一对多
     * 多对多: "aba", "baa"
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> s_to_t = new HashMap<Character, Character>();
        HashMap<Character, Character> t_to_s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char s_i = s.charAt(i);
            char t_i = t.charAt(i);
            if (!s_to_t.containsKey(s_i) && !t_to_s.containsKey(t_i)) {
                // put 保证s_to_t里的是一对一
                s_to_t.put(s_i, t_i);
                t_to_s.put(t_i, s_i);
            } else if (s_to_t.containsKey(s_i) && t_i == s_to_t.get(s_i)){}
            else return false; // 其他情况都是false
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("ab", "aa"));
    }
}
