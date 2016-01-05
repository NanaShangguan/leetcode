package nano.shangguan;

/**
 * Created by Nano on 2016/1/5.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int len = (int) Math.sqrt(n);
        int[] num = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = i;
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                int count = num[i - square] + 1;
                if (min > count) min = count;
            }
            num[i] = min;
        }
        return num[n];
    }
}
