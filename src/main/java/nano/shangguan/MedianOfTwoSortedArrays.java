package nano.shangguan;

/**
 * Created by Nano on 2015/10/10.
 * 如果一个数，第一个数组中比它小的数有k1个，第二个数组中比它
 * 小的数有k2个，且(k1 + k2) == (m + n) / 2
 * 如果总长度是奇数，则该数即为median
 * 如果总长度是偶数，则还需要找另一个median2，是大小仅次于median的数
 * 正确的median是两个median的mean
 *
 * 现在第一个数组中以二分法取数，计算两个数组中比它小的数的个数总和，进行比较
 * 迭代进行，有多种情况，分别处理
 *
 * 看其他大神的解法
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int low1 = 0, high1 = len1 - 1, low2 = 0, high2 = len2 - 1;
        int middleCount = (len1 + len2) / 2;
        int mod = (len1 + len2) % 2;
        int smallerCount = 0; //第二个数组中比当前数小的数个数
        int median = 0, median2 = 0;
        while (low1 <= high1) {
            int middle1 = (low1 + high1) / 2;
            int value = nums1[middle1];
            //在第二个数组中二分查找当前数
            while (low2 <= high2) {
                int middle2 = (low2 + high2) / 2;
                if (value == nums2[middle2]) {
                    smallerCount = middle2;
                    break;
                } else if (value < nums2[middle2])
                    high2 = middle2 - 1;
                else low2 = middle2 + 1;
            }
            //如果当前数不在第二个数组中
            if (low2 > high2) smallerCount = high2 + 1;

            //判断两部分count是不是等于长度之和的一半
            int totalCount = middle1 + smallerCount;
            if (totalCount == middleCount) {
                median = value;
                if (mod == 0) {
                    if (middle1 == 0) median2 = nums2[smallerCount - 1];
                    else if (smallerCount == 0) median2 = nums1[middle1 - 1];
                    else median2 = Math.max(nums1[middle1 - 1], nums2[smallerCount - 1]);
                }
                break;
            }
            if (totalCount < middleCount) {
                low1 = middle1 + 1;
                low2 = smallerCount;
                high2 = len2 - 1;
            }
            else {
                high1 = middle1 - 1;
                low2 = 0;
                high2 = smallerCount - 1;
            }
        }
        //median在第二个数组中
        if (low1 > high1) {
            int count = low1;
            //在[middleCount - count, len2)中找median
            low2 = middleCount - count;
            high2 = len2 - 1;
            while (low2 <= high2) {
                int middle = (low2 + high2) / 2;
                int totalCount = middle + count;
                if (totalCount == middleCount) {
                    median = nums2[middle];
                    if (mod == 0) {
                        if (middle == 0) median2 = nums1[count - 1];
                        else if (count == 0) median2 = nums2[middle - 1];
                        else median2 = Math.max(nums1[count - 1], nums2[middle - 1]);
                    }
                    break;
                }
                else if (totalCount < middleCount)
                    low2 = middle + 1;
                else high2 = middle - 1;
            }
        }

        return (mod == 0 ? ((median + median2) / 2D) : median);
    }

    public static void main(String[] args) {
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(
                new int[]{1, 2, 3}
                , new int[]{4, 5, 6, 7}
        ));
    }
}
