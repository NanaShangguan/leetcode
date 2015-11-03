package nano.shangguan;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int len = getLength(x);
        for (int f = 1, b = len; f < b; f++, b--)
        if (getNumOfIndex(x, f) != getNumOfIndex(x, b))
            return false;

        return true;
    }

    // ��ó���
    private int getLength(int x) {
        int i = 1;
        while(x >= 10) {
            x /= 10;
            i++;
        }
        return i;
    }
    //���ĳλ���ϵ����֣�ĩλindex��1
    private int getNumOfIndex(int x, int index) {
        for (int i = 1; i < index; i++) {
            x /= 10;
        }
        return x % 10;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(102220));
    }
}
