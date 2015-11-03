package nano.shangguan;

/**
 * Created by Nano on 2015/10/12.
 */
public class Pow {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        else if (n == 1) return x;
        else if (n == -1) return 1/x;
        else {
            double half = myPow(x, n/2);
            int mod = n % 2;
            return (mod == 0 ? half * half :
                    (mod == -1 ? half * half / x : half * half * x));
        }
    }

    public static void main(String[] args) {
        System.out.print(new Pow().myPow(2.0, -2));
    }
}
