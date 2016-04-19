package nano.shangguan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2016/4/19.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] b = new int[m + 1][n + 1];
        int[][] c = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 2;
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 3;
                }
            }
        }

        int total = 0;
        int last1 = m, last2 = n;
        for (int i = m, j = n; i > 0 && j > 0;) {
            if (b[i][j] == 1) {
                total += Math.max(last1 - i, last2 - j);
                i--;
                j--;
                last1 = i;
                last2 = j;
            } else if (b[i][j] == 2) i--;
            else if (b[i][j] == 3) j--;
        }


        return total;
    }
}
