package nano.shangguan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2015/12/25.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix.length > 0) {
            int rowLen = matrix.length, colLen = matrix[0].length;
            int rowStart = 0, rowEnd = rowLen, colStart = -1, colEnd = colLen;
            boolean rowTurn = true;
            int pointRow = 0, pointCol = -1;

            while (true) {
                //一次circle
                if (++pointCol < colEnd) {
                    //上面的行
                    while (pointCol < colEnd) list.add(matrix[pointRow][pointCol++]);
                    //更新边界
                    colEnd = --pointCol;
                    if (++pointRow < rowEnd) {
                        //右边的列
                        while (pointRow < rowEnd) list.add(matrix[pointRow++][pointCol]);
                        rowEnd = --pointRow;
                        if (--pointCol > colStart) {
                            //下面的行
                            while (pointCol > colStart) list.add(matrix[pointRow][pointCol--]);
                            colStart = ++pointCol;
                            if (--pointRow > rowStart) {
                                //左边的列
                                while (pointRow > rowStart) list.add(matrix[pointRow--][pointCol]);
                                rowStart = ++pointRow;
                            } else break;
                        } else break;
                    } else break;
                } else break;
            }
        }

        return list;
    }
}
