package nano.shangguan;

/**
 * Created by Nano on 2015/10/12.
 */
public class SearchA2DMatrix {
    /**
     * 先找出所属行，再找出列，都是用二分法
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            int value = matrix[middle][0];
            if (value == target) return true;
            else if (value < target) low = middle + 1;
            else high = middle - 1;
        }
        //确定了行号
        if (high != -1) {
            int[] row = matrix[high];
            low = 1;
            high = row.length - 1;
            while (low <= high) {
                int middle = (low + high) / 2;
                int value = row[middle];
                if (value == target) return true;
                else if (value < target) low = middle + 1;
                else high = middle - 1;
            }
        }
        return false;
    }
}
