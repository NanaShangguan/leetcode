package nano.shangguan;

/**
 * Created by Nano on 2016/4/15.
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        return kmp(haystack, needle);
    }

    private int kmp(String s, String sub) {
        if (s.length() >= sub.length()) {
            if (sub.length() == 0) return 0;
            //对sub求next数组
            int[] next = new int[sub.length()];
            next[0] = -1;
            for (int i = 1; i < sub.length(); i++) {
                next[i] = -1;
                int index = i - 1;
                while (index > -1) {
                    index = next[index];
                    if (sub.charAt(index + 1) == sub.charAt(i)) {
                        next[i] = index + 1;
                        break;
                    }
                }
            }

            //匹配
            for (int i = 0, j = 0; ; ) {
                if (j == sub.length()) return i - j;
                if (i == s.length()) break;
                if (s.charAt(i) == sub.charAt(j)) {
                    i++;
                    j++;
                } else {
                    if (j > 0) j = next[j - 1] + 1;
                    else i++;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "BBC ABCDAB ABCDABCDABDE";
        String sub = "ABCDABD";
        System.out.println(s.indexOf(sub));
    }
}
