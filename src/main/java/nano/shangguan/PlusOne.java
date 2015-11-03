package nano.shangguan;

/**
 * Created by Nano on 2015/4/30.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean plus = true;

        for (int i = len - 1; plus && i >= 0; i--) {
            plus = (digits[i] + 1) >= 10;
            digits[i] = (digits[i] + 1) % 10;
        }

        if (plus) {
            int[] newDigits = new int[len + 1];
            System.arraycopy(digits, 0, newDigits, 1, len);
            newDigits[0] = 1;

            return newDigits;
        } else return digits;
    }

    public int[] plusAny(int[] digits, int plus) {
        int len = digits.length;
        int cur;

        for (int i = len - 1; plus != 0 && i >= 0; i--) {
            cur = digits[i];
            digits[i] = (cur + plus) % 10;
            plus = (cur + plus) / 10;
        }

        if (plus != 0) {
            int[] newDigits = new int[len + 1];
            System.arraycopy(digits, 0, newDigits, 1, len);
            newDigits[0] = plus;

            return newDigits;
        } else return digits;
    }

    public static void main(String[] args) {
        int[] a = new PlusOne().plusOne(new int[]{9, 9, 9, 9});
        for (int digit : a)
            System.out.print(digit);
    }
}
