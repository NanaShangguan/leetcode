package nano.shangguan;

/**
 * Created by Nano on 2015/10/9.
 * 牛顿迭代法
 */
public class Sqrt {
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        double t = x;
        while (Math.abs(t - x/t) >= 1) {
            t = (x/t + t) / 2;
        }
        int result = (int) t;
        return result * result > x ? result - 1 : result;
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(3));
    }
}
