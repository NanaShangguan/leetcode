package nano.shangguan;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created by Nano on 2015/7/15.
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int n, int d) {
        boolean isPositive = true;
        if ((n < 0 && d > 0) || (n > 0 && d < 0))
            isPositive = false;
        BigInteger numerator = new BigInteger(n + "").abs();
        BigInteger denominator = new BigInteger(d + "").abs();
        String intPart = (isPositive ? "" : "-") + numerator.divide(denominator).toString();
        numerator = numerator.remainder(denominator);
        if (numerator.intValue() == 0)
            return intPart;
        String result = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int i = 0;
        while (true) {
            String pair = numerator.toString() + "/" + denominator.toString();
            if (map.containsKey(pair)) {
                int index = map.get(pair);
                String subString = result.substring(index, i);
                return intPart + "." + result.replace(subString, "(" + subString + ")");
            } else {
                map.put(pair, i++);
                numerator = numerator.multiply(new BigInteger("10"));
                result += numerator.divide(denominator).toString();
                numerator = numerator.remainder(denominator);
                if (numerator.intValue() == 0) return intPart + "." + result;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(-1, -2147483648));
    }
}
