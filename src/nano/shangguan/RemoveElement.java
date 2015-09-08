package nano.shangguan;

/**
 * Created by Nano on 2015/4/29.
 */
public class RemoveElement {

    public int removeElement1(int[] A, int elem) {
        int tmp;
        int p1 = 0, p2 = A.length - 1;
        while (true) {
            while (p1 < A.length && A[p1] != elem)
                ++p1;
            while (p2 >= 0 && A[p2] == elem)
                --p2;
            if (p1 < p2) {
                tmp = A[p1];
                A[p1++] = A[p2];
                A[p2--] = tmp;
            } else break;
        }

        return p1;
    }

    public int removeElement2(int[] A, int elem) {
        int counter = 0;
        for (int i = 0, j = 0; i < A.length; i++) {
            if (A[i] != elem)
                A[j++] = A[i];
            else counter++;
        }

        return A.length - counter;
    }

    public static void main (String[] args) {
        System.out.println(new RemoveElement().removeElement1(new int[]{}, 1));
    }
}
