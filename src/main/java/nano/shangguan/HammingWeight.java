package nano.shangguan;

/**
 * Created by Nano on 2016/1/14.
 */
class HammingWeight {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count++;
            n >>= 1;
        }
        return count;
    }
}
