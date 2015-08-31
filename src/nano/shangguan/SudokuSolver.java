package nano.shangguan;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Nano on 2015/8/28.
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        isGood(board, 0, 0);
    }

    public boolean isGood(char[][] board, int row, int col) {
        //从当前位置寻找下一个空格
        int[] next = findNextEmptyCell(board, row, col);
        //如果没找到，说明数独完成，返回true
        if (next == null) return true;
        else {
            //获取下个位置上可能填写的值
            int nextRow = next[0];
            int nextCol = next[1];
            HashMap<Character, Boolean> available = getAvailableNumbers(board, nextRow, nextCol);
            //如果该格子上没有可选的值，说明之前的选值有错误，返回false
            if (available.size() == 0)
                return false;
            //开始遍历
            Iterator<Character> it = available.keySet().iterator();
            while(it.hasNext()) {
                char each = it.next();
                board[nextRow][nextCol] = each;
                //检测之后的的格子是不是都符合要求，是的话，返回true
                if (isGood(board, nextRow, nextCol))
                    return true;
            }
            //删除填入的值
            board[nextRow][nextCol] = '.';
            return false;
        }
    }

    public int[] findNextEmptyCell(char[][] board, int row, int col) {
        for (int i = row; i < board.length; i++) {
            for (int j = (i == row ? col : 0); j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public HashMap<Character, Boolean> getAvailableNumbers(char[][] board, int row, int col) {
        HashMap<Character, Boolean> available = new HashMap<Character, Boolean>(){
            {
                put('1', true);
                put('2', true);
                put('3', true);
                put('4', true);
                put('5', true);
                put('6', true);
                put('7', true);
                put('8', true);
                put('9', true);
            }
        };
        //排除所在行
        for(char each : board[row]) {
            if (Character.isDigit(each) && available.containsKey(each))
                available.remove(each);
        }
        //排除所在列
        for(int i = 0; i < board.length; i++) {
            char each = board[i][col];
            if (Character.isDigit(each) && available.containsKey(each))
                available.remove(each);
        }
        //排除所在九宫格
        int row_base = (row / 3) * 3;
        int col_base = (col / 3) * 3;
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char each = board[row_base + i][col_base + j];
                if (Character.isDigit(each) && available.containsKey(each))
                    available.remove(each);
            }
        }
        return available;
    }
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        new SudokuSolver().solveSudoku(board);
        for(int i = 0 ; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++)
                System.out.print(board[i][j] + "  ");
            System.out.println();
        }
//        System.out.println(board);
    }
}
