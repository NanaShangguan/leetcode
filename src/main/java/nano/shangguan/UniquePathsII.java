package nano.shangguan;

/**
 * Created by Nano on 2015/7/7.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[] dp = new int[col];
        // 初始化状态矩阵
        dp[0] = (obstacleGrid[0][0] == 1) ? 0 : 1;
        for (int i = 1; i < col; i++)
            dp[i] = obstacleGrid[0][i] == 1 ? 0 : dp[i - 1];
        // 计算 & 动态更新
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 1) dp[0] = 0;
            for (int j = 1; j < col; j++) {
                dp[j] = (obstacleGrid[i][j] == 1) ? 0 : dp[j] + dp[j - 1];
            }
        }
        return  dp[col - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][]{{0, 0}}));
    }
}
