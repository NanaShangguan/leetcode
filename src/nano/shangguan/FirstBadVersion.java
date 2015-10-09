package nano.shangguan;

/**
 * Created by Nano on 2015/10/9.
 * 整数相加溢出
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low < high) {
            int middle = low / 2 + high / 2;
            if (isBadVersion(middle)) {
                if (middle == 1 || !isBadVersion(middle - 1))
                    return middle;
                high = middle - 1;
            } else low = middle + 1;
        }
        return low;
    }

    public boolean isBadVersion(int version) {
        return (version >= 1702766719) ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(2126753390));
    }
}
