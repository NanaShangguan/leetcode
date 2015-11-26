package nano.shangguan;

import java.util.LinkedList;

/**
 * Created by Nano on 2015/11/26.
 */
public class SurroundedRegions {
    private boolean[][] shouldBeChanged;
    public void solve(char[][] board) {
        if (board.length == 0) return;
        int rows = board.length, cols = board[0].length;
        shouldBeChanged = new boolean[rows][cols];
        //将'O'的change位设置为true
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (board[i][j] == 'O') shouldBeChanged[i][j] = true;
        //将与边缘连通的'O'的change位设置为false
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                //扫描所有边缘的
                if ((i == 0 || i == rows - 1)
                        || (j == 0 || j == cols - 1)) {
                    if (shouldBeChanged[i][j] && board[i][j] == 'O') {
                        //与它连通的所有'O'的change位设置为false
                        setAllConnectedBigOToFalse(board, i, j);
                    }
                }
            }
        //将shouldBeChanged为true的位置在board中改为'X'
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (shouldBeChanged[i][j]) board[i][j] = 'X';
    }
    private void setAllConnectedBigOToFalse
            (char[][] board, int rowIndex, int colIndex) {
        LinkedList<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{rowIndex, colIndex});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            rowIndex = cur[0];
            colIndex = cur[1];
            if (shouldBeChanged[rowIndex][colIndex]) {
                shouldBeChanged[rowIndex][colIndex] = false;
                //左
                if (colIndex > 0 && board[rowIndex][colIndex - 1] == 'O')
                    queue.add(new int[]{rowIndex, colIndex - 1});
                //右
                if (colIndex < board[0].length - 1 && board[rowIndex][colIndex + 1] == 'O')
                    queue.add(new int[]{rowIndex, colIndex + 1});
                //上
                if (rowIndex > 0 && board[rowIndex - 1][colIndex] == 'O')
                    queue.add(new int[]{rowIndex - 1, colIndex});
                //下
                if (rowIndex < board.length - 1 && board[rowIndex + 1][colIndex] == 'O')
                    queue.add(new int[]{rowIndex + 1, colIndex});
            }
        }
    }
}