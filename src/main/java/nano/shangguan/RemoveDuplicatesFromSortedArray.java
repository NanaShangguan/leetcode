package nano.shangguan;

/**
 * Created by Nano on 2015/4/29.
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] A) {
        if (A.length == 0)
            return 0;
        int counter = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[counter]) {
                A[++counter] = A[i];
            }
        }

        return counter + 1;
    }

    public static void main (String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{1,1,2}));
    }
}
