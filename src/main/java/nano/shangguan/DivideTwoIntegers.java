package nano.shangguan;

/**
 * Created by Nano on 2016/3/1.
 */
public class DivideTwoIntegers {
    public int divide(int dividendInt, int divisorInt) {
        long dividend = dividendInt, divisor = divisorInt;
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;

        //处理结果符号
        boolean isPositive = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) isPositive = false;
        if (dividend < 0) dividend = -dividend; //overflow
        if (divisor < 0) divisor = -divisor;    //overflow

        long result = 0;
        if (dividend >= divisor) {
            long multiple = 1;  //overflow
            for ( ; (divisor << 1) <= dividend; divisor <<= 1) {
                multiple <<= 1;
            }
            while (divisor > 0) {
                if (dividend >= divisor) {
                    dividend -= divisor;
                    result += multiple;
                }
                divisor >>= 1;
                multiple >>= 1;
            }
        }
        if (isPositive) {
            if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            return (int) result;
        } else {
            result = -result;
            if (result < Integer.MIN_VALUE) return Integer.MAX_VALUE;
            return (int) result;
        }
    }

    /* Time Limit Exceeded
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        boolean isPositive = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) isPositive = false;
        if (dividend < 0) dividend = -dividend;
        if (divisor < 0) divisor = -divisor;
        int multiple = 0;
        while (dividend > divisor) {
            multiple++;
            dividend -= divisor;
        }
        return (isPositive ? multiple : -multiple);
    }
     */
}
