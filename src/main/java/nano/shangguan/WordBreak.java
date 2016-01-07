package nano.shangguan;

import java.util.Set;

/**
 * Created by Nano on 2016/1/7.
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        if (len == 0) return wordDict.contains("");
        boolean[] dp = new boolean[len];
        dp[0] = wordDict.contains(s.charAt(0) + "");
        for (int i = 1; i < len; i++) {
            if (wordDict.contains(s.substring(0, i + 1))) dp[i] = true;
            else {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[len - 1];
    }
}
