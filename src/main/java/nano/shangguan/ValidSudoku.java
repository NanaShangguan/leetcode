package nano.shangguan;

import java.util.HashMap;

/**
 * Created by Nano on 2015/7/15.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, Object> map = new HashMap<Character, Object>();
        int rowLen = board.length;
        int colLen = board[0].length;
//        // 行检测
//        for (int row = 0; row < rowLen; row++) {
//            map.clear();
//            for (int col = 0; col < colLen; col++) {
//                if (map.containsKey(board[row][col])) return false;
//                map.put(board[row][col], null);
//            }
//        }
//        // 列检测
//        for (int col = 0; col < colLen; col++) {
//            map.clear();
//            for (int row = 0; row < rowLen; row++) {
//                if (map.containsKey(board[row][col])) return false;
//                map.put(board[row][col], null);
//            }
//        }
        // rowLen equals to colLen
        // 增加一个map，减少时间
        HashMap<Character, Object> map2 = new HashMap<Character, Object>();
        for (int row = 0; row < rowLen; row++) {
            map.clear();
            map2.clear();
            for (int col = 0; col < colLen; col++) {
                if (board[row][col] != '.') {
                    if (map.containsKey(board[row][col])) return false;
                    map.put(board[row][col], null);
                }
                if (board[col][row] != '.') {
                    if (map2.containsKey(board[col][row])) return false;
                    map2.put(board[col][row], null);
                }
            }
        }

        // 九宫格检测
        // rgi = row grid index
        // cgi = col grid index
        // num = number of grids in a row
        int num = rowLen / 3;
        for (int rgi = 0; rgi < num; rgi++) {
            for (int cgi = 0; cgi < num; cgi++) {
                map.clear();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[rgi * 3 + i][cgi * 3 + j] != '.') {
                            if (map.containsKey(board[rgi * 3 + i][cgi * 3 + j])) return false;
                            map.put(board[rgi * 3 + i][cgi * 3 + j], null);
                        }
                    }
                }
            }
        }
        return true;
    }
}
