package nano.shangguan;

import java.util.HashMap;

/**
 * Created by Nano on 2015/8/31.
 */
public class IntegerToEnglishWords {
    private HashMap<Integer, String> map = new HashMap<Integer, String>(){{
        put(1, "One");
        put(2, "Two");
        put(3, "Three");
        put(4, "Four");
        put(5, "Five");
        put(6, "Six");
        put(7, "Seven");
        put(8, "Eight");
        put(9, "Nine");
        put(10, "Ten");
        put(11, "Eleven");
        put(12, "Twelve");
        put(13, "Thirteen");
        put(14, "Fourteen");
        put(15, "Fifteen");
        put(18, "Eighteen");
        put(20, "Twenty");
        put(30, "Thirty");
        put(40, "Forty");
        put(50, "Fifty");
        put(80, "Eighty");

    }};
    private String[] level = {"Thousand ", "Million ", "Billion "};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String numString = num + "";
        String words = "";
        for (int i = numString.length(), j = -1; i > 0; i -= 3, j++) {
            String str = threeDigitsToWords(numString.substring((i - 3) < 0 ? 0 : (i - 3), i));
            if (!str.equals(""))
                str += (j != -1 ? level[j % 3] : "");
            words = str + words;
        }
        return words.trim();
    }

    /**
     * 把三位数转换成words
     * @param numString 数字的字符串
     * @return words
     */
    private String threeDigitsToWords(String numString) {
        int num = Integer.parseInt(numString);
        if (num == 0) return "";
        String words = "";
        //获取百位数字
        int hundreds = num / 100;
        //十位数字
        num %= 100;
        int tens = num / 10;
        //个位数字
        num %= 10;
        int ones = num;
        //处理百位数
        if (hundreds != 0)
            words += map.get(hundreds) + " Hundred ";

        //处理十位数以及个位数
        if (tens == 1) {
            // 特殊处理
            if (map.containsKey(tens * 10 + ones))
                words += map.get(tens * 10 + ones) + " ";
            else words += map.get(ones) + "teen ";
        } else {
            if (tens != 0) {
                if (map.containsKey(tens * 10))
                    words += map.get(tens * 10) + " ";
                else words += map.get(tens) + "ty ";
            }
            if (ones != 0)
                words += map.get(ones) + " ";
        }
        return words;
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToEnglishWords().numberToWords(1000000));
    }
}
