package nano.shangguan;

/**
 * Created by Nano on 2015/4/27.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        int sum = 0;
        if (n > 1) {
            boolean[] markList = new boolean[n];
            markList[0] = markList[1] = true;
            for (int i = 2; i * i < n; ) {
                for (int j = i * i; j < n; j += i)
                    markList[j] = true;
                for (int j = i + 1; j < n; j++)
                    if (!markList[j]) {
                        i = j;
                        break;
                    }
            }

            for (boolean each : markList) {
                if (!each)
                    ++sum;
            }
        }

        return sum;
    }

    public static void main (String[] args) {
        System.out.println(new CountPrimes().countPrimes(10000000));
    }
}
