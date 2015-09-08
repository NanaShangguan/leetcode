package nano.shangguan;

import java.util.HashMap;

/**
 * Created by Nano on 2015/7/15.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        HashMap<Integer, Object> map = new HashMap<Integer, Object>();
        map.put(n, null);

        while (true) {
            String n_str = n + "";
            int len = n_str.length();
            int sum = 0;
            for (int i = 0; i < len; i++) {
                int eachInt = Integer.parseInt(n_str.substring(i, i + 1));
                sum += eachInt * eachInt;
            }
            if (sum == 1) return true;
            else if (map.containsKey(sum)) return false;
            else map.put(sum, null);

            n = sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19));
    }
}
