package nano.shangguan;


/**
 * Created by Nano on 2015/9/9.
 */
public class UniqueBinarySearchTrees {
    /**
     * 算一半乘以2
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = 0;
            for (int j = 1; j <= i / 2; j++) {
                f[i] += f[j - 1] * f[i - j];
            }
            f[i] *= 2;
            if (i % 2 == 1) {
                int j = (i + 1) / 2;
                f[i] += f[j - 1] * f[i - j];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees().numTrees(5));
    }
}
