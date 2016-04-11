package nano.shangguan;

/**
 * Created by Nano on 2016/4/6.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        int[] f = new int[len];
        f[0] = 1;
        int maxRightIndex = 0;
        for (int i = 1; i < len; i++) {
            int index = i - f[i - 1] - 1;
            if (index < 0 || s.charAt(i) != s.charAt(index)) {
                //重新寻找回文
                for (int j = index + 1; j < i; j++) {
                    if (isPalindromic(s, j, i)) {
                        f[i] = (i - j + 1);
                        break;
                    }
                }
                if (f[i] == 0) f[i] = 1;
            } else f[i] = f[i - 1] + 2;
            if (f[i] > f[maxRightIndex]) maxRightIndex = i;
        }
        return s.substring(maxRightIndex - f[maxRightIndex] + 1, maxRightIndex + 1);
    }

    /**
     * [start, end]
     * @param s
     * @param start
     * @param end
     * @return
     */
    private boolean isPalindromic(String s, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
