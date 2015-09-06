package nano.shangguan;

import java.util.Arrays;

/**
 * Created by Nano on 2015/9/6.
 */
public class HIndex {
    /**
     *  1. ����
     *  2. ����Ȼ������ͬʱ�����ҳ���С��hֵ
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
//        quickSort(citations);
        Arrays.sort(citations);
        return hIndexOnSortedArraySolution1(citations);
//        return hIndexOnSortedArraySolution2(citations);
    }

    /**
     * ����Ȼ������ͬʱ�����ҳ���С��hֵ
     * @param citations
     * @return
     */
    private int hIndexOnSortedArraySolution1(int[] citations) {
        int len = citations.length;
        for (int i = 0, j = 0; i < len && j <= len; ) {
            if (len - i == j) return j;
            if (j < citations[i]) j++;
            else i++;
        }
        return 0;
    }

    /**
     * ���ַ�
     * @param citations
     * @return
     */
    private int hIndexOnSortedArraySolution2(int[] citations) {
        int low = 0, len = citations.length, high = len - 1;
        while (low < high) {
            int middleIndex = (low + high) / 2;
            int middleValue = citations[middleIndex];
            if (middleValue < len - middleIndex) low = middleIndex + 1;
            else if (middleValue > len - middleIndex) high = middleIndex - 1;
            else return middleValue;
        }
        int h = len - low;
        if (h > citations[low]) return h - 1;
        else return h;
    }

    /**
     * ��������
     * @param arr �����������
     */
    private void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    private void sort(int[] arr, int start, int end) {
        if (!(start < end && start >= 0 && end < arr.length)) return;
        int pivot = arr[start];
        int low = start;
        int high = end;
        while (low < high) {
            while (low < high && arr[high] >= pivot) high--;
            if (low < high) arr[low++] = arr[high];
            while (low < high && arr[low] <= pivot) low++;
            if (low < high) arr[high--] = arr[low];
        }
        arr[low] = pivot;
        sort(arr, start, low - 1);
        sort(arr, low + 1, end);
    }

//    [3, 0, 6, 1, 5]
    public static void main(String[] args) {
        int[] arr = { 0, 0, 13 };
        System.out.println(new HIndex().hIndex(arr));
    }
}
