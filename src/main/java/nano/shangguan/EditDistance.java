package nano.shangguan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nano on 2016/4/19.
 */
public class EditDistance {
    static class CommonSeq {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        List<CommonSeq>[][] b = new List[m + 1][n + 1];
        int[][] c = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    List<CommonSeq> leftUp = b[i - 1][j - 1];
                    if (leftUp == null) {
                        List<CommonSeq> cur = new ArrayList<CommonSeq>();
                        CommonSeq seq = new CommonSeq();
                        seq.list1.add(i - 1);
                        seq.list2.add(j - 1);
                        cur.add(seq);
                        b[i][j] = cur;
                    } else {
                        List<CommonSeq> cur = new ArrayList<CommonSeq>(leftUp);
                        for (CommonSeq seq : cur) {
                            seq.list1.add(i - 1);
                            seq.list2.add(j - 1);
                        }
                        b[i][j] = cur;
                    }
                } else if (c[i - 1][j] > c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    if (b[i - 1][j] != null) b[i][j] = new ArrayList<CommonSeq>(b[i - 1][j]);
                } else if (c[i - 1][j] < c[i][j - 1]) {
                    c[i][j] = c[i][j - 1];
                    if (b[i][j - 1] != null) b[i][j] = new ArrayList<CommonSeq>(b[i][j - 1]);
                } else {
                    if (b[i - 1][j] != null) b[i][j] = new ArrayList<CommonSeq>(b[i - 1][j]);
                    if (b[i][j - 1] != null) {
                        if (b[i][j] == null) b[i][j] = new ArrayList<CommonSeq>(b[i][j - 1]);
                        else b[i][j].addAll(b[i][j - 1]);
                    }
                }
            }
        }


        int total = 0;
//        int last1 = m, last2 = n;
//        for (int i = m, j = n; i > 0 && j > 0;) {
//            if (b[i][j] == 1) {
//                total += Math.max(last1 - i, last2 - j);
//                i--;
//                j--;
//                last1 = i;
//                last2 = j;
//            } else if (b[i][j] == 2) i--;
//            else if (b[i][j] == 3) j--;
//        }
//
//        total += Math.max(last1, last2);

        return total;
    }
}
