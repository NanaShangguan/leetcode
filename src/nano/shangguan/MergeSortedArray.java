package nano.shangguan;

/**
 * Created by Nano on 2015/4/30.
 *
 * 这种题目要避免整体向后移位的操作
 */
public class MergeSortedArray {

    public void merge(int A[], int m, int B[], int n) {
        while (n > 0)
            A[m + n - 1] = (m == 0 || A[m - 1] < B[n - 1]) ? B[--n] : A[--m];
    }

    public void merge1(int A[], int m, int B[], int n) {
        for (int i = 0, j = 0; j < n; j++) {
        //顺序查找
            while (i < m && A[i] <= B[j]) i++;

        //将当前B中的元素插入到A
            //A中（i，m-1）的数整体向后移一位
            for (int k = m - 1; k >= i; k--)
                A[k + 1] = A[k];
            //B[j]赋值给A[i]
            A[i] = B[j];
            //A中的指针往后移一位，A的长度m加一
            i++; m++;
        }
    }

    public static void main (String[] args) {
        int[] A = {1,5,7,8,0,0,0,0,0,0};
        int[] B = {1,2,4,6,9,10};
        new MergeSortedArray().merge(A, 4, B, 6);
        for (int each : A)
            System.out.print(each + " ");
    }
}
