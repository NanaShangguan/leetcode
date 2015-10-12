package nano.shangguan;

/**
 * Created by Nano on 2015/10/12.
 */
public class SearchA2DMatrixII {
    /**
     * 蛇形搜索
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row_low = 0, row_high = matrix.length - 1;
        while (row_low <= row_high) {
            int row_middle = (row_low + row_high) / 2;
            int[] row = matrix[row_middle];
            int col_low = 0, col_high = row.length - 1;
            while (col_low <= col_high) {
                int col_middle = (col_low + col_high) / 2;
                int value = row[col_middle];
                if (value == target) return true;
                else if (value < target) col_low = col_middle + 1;
                else col_high = col_middle - 1;
            }

            if ((col_low + col_high) / 2 >= (row.length - 1) / 2)
                row_low = row_middle + 1;
            else row_high = row_middle - 1;
        }
        return false;
    }

    /**
     * 在矩阵的第row行的[low, high]中寻找最后一个比target小的元素的index
     * @param matrix 矩阵
     * @param rowIndex 行号
     * @param low 起始位置
     * @param high 结束位置
     * @param target 目标值
     * @return
     */
    public int searchInRow(int[][] matrix, int rowIndex, int low, int high, int target) {
        int[] row = matrix[rowIndex];
        while (low <= high) {
            int middle = (low + high) / 2;
            int value = row[middle];
            if (value == target) return middle;
            else if (value < target) low = middle + 1;
            else high = middle - 1;
        }
        if (high == -1) return -1;
        else if (low == row.length) return row.length;
        else return (row[low] > row[high] ? high : low);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15}
                , {2, 5, 8, 12, 19}
                , {3, 6, 9, 16, 22}
                , {10, 13, 14, 24, 25}
                , {18, 21, 23, 26, 30}
        };
        System.out.println(new SearchA2DMatrixII().searchInRow(matrix, 2, 0, 4, 21));
    }
}
