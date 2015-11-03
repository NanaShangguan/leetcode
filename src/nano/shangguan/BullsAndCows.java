package nano.shangguan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2015/11/2.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        //统计0-9每个数字出现的次数，当secret中出现时+1，guess中出现时-1
        int[] count = new int[10];
        int bulls = 0, cows = 0;
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                int s_index = secret.charAt(i) - '0';
                int g_index = guess.charAt(i) - '0';
                count[s_index]++;
                if (count[s_index] <= 0) cows++;
                count[g_index]--;
                if (count[g_index] >= 0) cows++;
            }
        }

        return bulls + "A" + cows + "B";

        /*
        int bulls = 0;
        //统计bull的下标
        for (int i = 0; i < len; ) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                secret = deleteCharAt(secret, i);
                guess = deleteCharAt(guess, i);
                len--;
            } else i++;
        }
        //统计cow
        int cows = 0;
        for (int i = 0; i < len; i++) {
            int index = guess.indexOf(secret.charAt(i));
            if (index != -1) {
                cows++;
                guess = deleteCharAt(guess, index);
            }
        }
        return bulls + "A" + cows + "B";
        */
    }

    private String deleteCharAt(String str, int index) {
        return str.substring(0, index) + (index == str.length() - 1 ? "" : str.substring(index + 1));
    }

    public static void main(String[] args) {
        System.out.println(new BullsAndCows().getHint("11", "10"));
    }
}
