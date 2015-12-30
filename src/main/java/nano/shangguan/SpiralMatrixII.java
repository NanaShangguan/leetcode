package nano.shangguan;

/**
 * Created by Nano on 2015/12/30.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int len = n;
        int value = 1;
        for (int row = 0, col = 0; len > 0; row++, col++) {
            //一圈
            int i = 0, j = 0;
            while (j < len) matrix[row + i][col + (j++)] = value++;
            j--;
            i++;
            while (i < len) matrix[row + (i++)][col + j] = value++;
            i--;
            j--;
            while (j > -1) matrix[row + i][col + (j--)] = value++;
            j++;
            i--;
            while (i > 0) matrix[row + (i--)][col + j] = value++;

            len -= 2;
        }
        return matrix;
    }
}
