package nano.shangguan;

/**
 * Created by Nano on 2015/9/22.
 */
public class RegularExpressionMatching {
    /**
     *
     * @param s 被检测字符串
     * @param p 正则表达式字符串
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s.equals("")) {
            if (p.equals("*")) return true;
            if (p.length() == 2 && p.charAt(1) == '*') return true;
            return false;
        }
        int k = 0, j = 0;
        while (k < s.length() && j < p.length()) {
            char s_c = s.charAt(k);
            char p_c = p.charAt(j);
            if (s_c == p_c || p_c == '.') {
                k++;
                j++;
            } else if (p_c == '*') {
                char prev = p.charAt(j - 1);
                if (s_c == prev || prev == '.') k++;
                else j++;
            }else j++;
        }

        if (k == s.length()) {
            if (j == p.length()) return true;
            else return isMatch("", p.substring(j));
        } else return false;
    }

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("aa", "a*"));
    }
}
