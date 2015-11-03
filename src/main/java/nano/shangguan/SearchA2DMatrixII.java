package nano.shangguan;

/**
 * Created by Nano on 2015/10/12.
 */
public class SearchA2DMatrixII {
    /**
     * 经典题，从右上角开始搜索，没用到二分搜索
     * 时间复杂度O(m + n)
     * 印象笔记中记录了其他解法
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row_num = matrix.length, col_num = matrix[0].length;
        int i = 0, j = matrix[0].length - 1;
        while (i < row_num && i > -1 && j < col_num && j > -1) {
            int value = matrix[i][j];
            if (value == target) return true;
            else if (value < target) i++;
            else j--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15}
                , {2, 5, 8, 12, 19}
                , {3, 6, 9, 16, 22}
                , {10, 13, 14, 24, 25}
                , {18, 21, 23, 26, 30}
        };
        System.out.println(new SearchA2DMatrixII().searchMatrix(matrix, 20));
    }
}
