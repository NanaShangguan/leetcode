package nano.shangguan;

/**
 * Created by Nano on 2016/4/25.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][][] dp = new int[m][n][2];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') dp[i][j] = new int[]{0, 0};
                else {
                    int upH, upW, leftH, leftW;
                    if (i == 0) { upH = 0; upW = 0; } else { upH = dp[i - 1][j][1]; upW = dp[i - 1][j][0]; }
                    if (j == 0) { leftW = 0; leftH = 0; } else { leftH = dp[i][j - 1][1]; leftW = dp[i][j - 1][0]; }
                    int uph = upH + 1, upw = Math.min(upW == 0 ? 1 : upW, leftW + 1);
                    int leftw = leftW + 1, lefth = Math.min(upH + 1, leftH == 0 ? 1 : leftH);
                    int upArea = uph * upw, leftArea = lefth * leftw;
                    if (upArea > leftArea) {
                        dp[i][j] = new int[]{upw, uph};
                    } else dp[i][j] = new int[]{leftw, lefth};
                }
                int area = dp[i][j][0] * dp[i][j][1];
                if (max < area) max = area;
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        char[][] matrix = {{'1', '0', '1', '0', '0'},{'1', '0', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '0', '0', '1', '0'}};
//        char[][] matrix = {{'1', '1'}};
        char[][] matrix = {"1011100010".toCharArray(),"0100000110".toCharArray(),"0101000011".toCharArray(),"1110000010".toCharArray(),"0111001010".toCharArray(),"1101101110".toCharArray()};
                System.out.println(new MaximalRectangle().maximalRectangle(matrix));
    }
}
