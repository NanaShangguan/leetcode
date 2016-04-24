package nano.shangguan;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Сô on 2016/4/23.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] factorials = new int[n];
        factorials[0] = 1;
        for (int i = 1; i < n; i++) factorials[i] = factorials[i - 1] * (i + 1);
        StringBuilder sb = new StringBuilder();
        int j = n - 2;
        boolean[] used = new boolean[n + 1];
        if (j > -1) {
            while (k > 0) {
                int i = (int) Math.ceil(k / (double) factorials[j]);
                int num = 1;
                while (i > 0) {
                    if (!used[num]) i--;
                    if (i == 0) break;
                    num++;
                }
                used[num] = true;
                sb.append(num);
                k %= factorials[j];
                j--;
            }
        }

        for (int i = n; i > 0; i--)
            if (!used[i]) sb.append(i);

        return sb.toString();
    }

    String getString(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int n : nums) sb.append(n);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(1, 1));
    }
}
