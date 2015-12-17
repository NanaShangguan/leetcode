package nano.shangguan;

import java.util.List;

/**
 * Created by Nano on 2015/12/16.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len == 0) return 0;
        int[] dp = new int[len * (len + 1) / 2];
        //最后一行赋值
        List<Integer> lastRow = triangle.get(len - 1);
        for (int i = 0; i < lastRow.size(); i++)
            dp[dp.length - i - 1] = lastRow.get(lastRow.size() - i - 1);
        //自底向上
        for (int i = len - 2; i >= 0; i--) {
            List<Integer> current = triangle.get(i);
            int index = i * (i + 1) / 2;
            for (int j = 0; j <= i; j++) {
                dp[index + j] = Math.min(dp[index + j + i + 1], dp[index + j + i + 2]) + current.get(j);
            }
        }
        return dp[0];
    }
}
