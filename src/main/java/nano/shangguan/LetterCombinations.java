package nano.shangguan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2016/4/13.
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if (digits.equals("")) return list;
        char[][] map = { {}, {},
                { 'a', 'b', 'c' }, { 'd', 'e', 'f' },
                { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
                { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' },
                { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' },
        };

        int len = 1;
        //string to int[]
        int[] nums = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            nums[i] = digits.charAt(i) - '0';
            len *= map[nums[i]].length;
        }

        //repeat[]
        int[] repeat = new int[nums.length];
        repeat[nums.length - 1] = 1;
        for (int i = nums.length - 2; i > -1; i--) {
            repeat[i] = map[nums[i + 1]].length * repeat[i + 1];
        }
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < nums.length; j++) {
                sb.append(map[nums[j]][i / repeat[j] % map[nums[j]].length]);
            }
            list.add(sb.toString());
        }
        return list;
    }
}
