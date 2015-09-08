package nano.shangguan;

/**
 * Created by Nano on 2015/6/29.
 * 回溯法
 * 两种实现：递归、stack
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] dirty = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == word.charAt(0) && search(board, row, col, word, 1, dirty)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * 每个字符最多有4个相邻的字符，需要注意边界字符的判断
     * 递归结束：i = word.length(), return true
     * 临界测试：board为空，word为空
     *
     * 判断当前位置上下左右的字符是不是与字符串当前位置中的字符相同，如果相同，递归调用
     *
     * @param board
     * @param row
     * @param col
     * @param word
     * @param i
     */
    private boolean search(char[][] board, int row, int col, String word, int i, boolean[][] dirty) {
        // 结束
        if (i == word.length()) return true;

        // 设置当前字符的dirty位为true
        dirty[row][col] = true;

        // 左字符（第一列字符除外）
        if (col != 0
                && !dirty[row][col - 1]
                && board[row][col - 1] == word.charAt(i)
                && search(board, row, col - 1, word, i + 1, dirty)) return true;
        // 下字符（最后一行除外）
        if (row != board.length - 1
                && !dirty[row + 1][col]
                && board[row + 1][col] == word.charAt(i)
                && search(board, row + 1, col, word, i + 1, dirty)) return true;
        // 右字符（最后一列除外）
        if (col != board[0].length - 1
                && !dirty[row][col + 1]
                && board[row][col + 1] == word.charAt(i)
                && search(board, row, col + 1, word, i + 1, dirty)) return true;
        // 上字符（第一行除外）
        if (row != 0
                && !dirty[row - 1][col]
                && board[row - 1][col] == word.charAt(i)
                && search(board, row - 1, col, word, i + 1, dirty)) return true;

        // 如果都不匹配，则当前路不通，标记为设置为false
        dirty[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch().exist(new char[][] {{'A', 'B', 'C', 'D'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
    }
}
