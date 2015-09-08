package nano.shangguan;

import java.math.BigInteger;

/**
 * Created by Nano on 2015/7/7.
 */
public class UniquePaths {
    /**
     * C(8, 2) = A(8, 2) / A(2, 2)
     * C(n, m) = A(n, n) / (A(n - m, n - m) * A(m, m)) = n! / ((n - m)! * m!)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int Cn = (m - 1) + (n - 1);
        int Cm = m - 1;
        return getFactorial(Cn).divide(getFactorial(Cn - Cm).multiply(getFactorial(Cm))).intValue();
    }

    private BigInteger getFactorial(int n) {
        BigInteger factorial = new BigInteger("1");
        for (int i = 2; i <= n; i++)
            factorial = factorial.multiply(new BigInteger(i + ""));
        return factorial;
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(36, 7));
    }
}
