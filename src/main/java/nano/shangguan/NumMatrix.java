package nano.shangguan;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nano on 2016/1/4.
 */
public class NumMatrix {
    private int[][] matrix = null;
    private Map<String, Map<int[], Integer>> history = null;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        history = new HashMap<String, Map<int[], Integer>>();
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        String key = row1 + "," + col1;
        if (history.containsKey(key)) {
            Map<int[], Integer> list = history.get(key);

        } else {
            //计算
            int sum = 0;
            for (int i = row1; i <= row2; i++)
                for (int j = col1; j <= col2; j++)
                    sum += matrix[i][j];
            Map<int[], Integer> list = new HashMap<int[], Integer>();
            list.put(new int[]{row2, col2}, sum);
            history.put(key, list);
            return sum;
        }
    }
}
