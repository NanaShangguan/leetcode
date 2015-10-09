package nano.shangguan;

/**
 * Created by Nano on 2015/10/9.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int middle = (low + high) / 2;
            if (nums[middle] == target)
                return middle;
            else {
                if (nums[low] < nums[middle]) {
                    if (target >= nums[low] && target < nums[middle])
                        high = middle - 1;
                    else low = middle + 1;
                } else {
                    if (target > nums[middle] && target <= nums[high])
                        low = middle + 1;
                    else high = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(
                new int[]{ 4, 5, 6, 7, 0, 1, 2 }
                , 6
        ));
    }
}
