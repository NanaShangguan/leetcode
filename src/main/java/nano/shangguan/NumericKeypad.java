package nano.shangguan;


import java.util.Scanner;

/**
 * Created by Nano on 2016/3/31.
 */
public class NumericKeypad {

    static int[][] keyboard = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
    };
    static int rowLen = keyboard.length, colLen = keyboard[0].length;

    static String getMaxProduct(String k, int startRow, int startCol) {
        if (k.equals("")) return "";

        int firstDigit = k.charAt(0) - '0';
        //从最大数字开始检索
        for (int i = rowLen - 1; i >= startRow; i--) {
            for (int j = colLen - 1; j >= startCol; j--) {
                int key = keyboard[i][j];
                if (key <= firstDigit) {
                    if (key < firstDigit) {
                        int len = k.length();
                        StringBuilder stringBuilder = new StringBuilder(len);
                        stringBuilder.append(key);
                        for (int p = 1; p < len; p++) stringBuilder.append("9");
                        return stringBuilder.toString();
                    }
                    String sub = getMaxProduct(k.substring(1), i, j);
                    if (sub != null) return keyboard[i][j] + sub;
                }
            }
        }
        if (startCol != 2) {
            int len = k.length();
            StringBuilder stringBuilder = new StringBuilder(len);
            for (int i = 0; i < len; i++) stringBuilder.append("0");
            return stringBuilder.toString();
        }
        return null;


        /*


        //计算第一位数字的坐标
        int row, col;
        if (firstDigit == 0) { row = 3; col = 1; }
        else {
            row = (firstDigit - 1) / 3;
            col = (firstDigit - 1) % 3;
        }
        //在右下方区域没有此数字
        if (row < startRow || col < startCol) {
            //如果是第一列和第二列可以选择0
            if (startCol != 2) {
                int len = k.length();
                StringBuilder stringBuilder = new StringBuilder(len);
                for (int i = 0; i < len; i++) stringBuilder.append("0");
                return stringBuilder.toString();
            }
            return null;
        }
        String sub = getMaxProduct(k.substring(1), row, col);
        if (sub == null) {
            if (col == startCol) {
                if (row == startRow) return null;
                row--; col = colLen - 1;
            } else col--;
            int len = k.length();
            StringBuilder stringBuilder = new StringBuilder(len);
            stringBuilder.append(keyboard[row][col]);
            for (int i = 1; i < len; i++) stringBuilder.append("9");
            return stringBuilder.toString();
        } else return firstDigit + sub;  */
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groups = scanner.nextInt();
        for (int i = 0; i < groups; i++) {
            String input = scanner.next();
            System.out.println(getMaxProduct(input, 0, 0));
        }
    }
}
