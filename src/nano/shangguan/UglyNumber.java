package nano.shangguan;

/**
 * Created by Nano on 2015/9/1.
 */
public class UglyNumber {
    /**
     * 因子只包含2，3，5的数
     * @param num
     * @return 是否是ugly
     */
    public boolean isUgly(int num) {
        if (num == 0) return false;
        int[] primes = { 2, 3, 5 };
        for (int prime : primes) {
            while (num % prime == 0)
                num /= prime;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumber().isUgly(14));
    }
}
