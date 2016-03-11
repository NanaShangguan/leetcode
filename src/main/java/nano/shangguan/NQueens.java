package nano.shangguan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2016/3/11.
 */
public class NQueens {
    //每个皇后独占一行及一列，positions[i]代表第i列上的皇后的行号（第一行是1）
    //0表示还没有被占领的列
    private int[] positions;
    private List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        positions = new int[n];
        result = new ArrayList<List<String>>();


    }

    /**
     * @param row 当前行
     * @param n 总行数
     */
    private void solveNQueensRecursively(int row, int n) {
        for (int i = 0; i < n; i++) {
            //当前列为空
            if (positions[i] == 0) {
                //验证当前行是否可用
                boolean available = true;
                for (int j = 0; j < n; j++) {
                    if (j == i) continue;
                    if (positions[j] != 0) {
                        //是否在一条对角线上
                        if (Math.abs((positions[i] - positions[j]) / (i - j)) == 1) {
                            available = false;
                            break;
                        }
                    }
                }
                if (available) {
                    positions[i] = row;
                    if (row == n) {
                        //生成结果list，加入到result

                        return;
                    }
                    solveNQueensRecursively(row + 1, n);
                }
            }
        }
    }
}
