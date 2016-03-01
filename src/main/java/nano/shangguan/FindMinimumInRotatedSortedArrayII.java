package nano.shangguan;

/**
 * Created by Nano on 2016/3/1.
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int len = nums.length;
        int low = 0, high = len - 1;
        while (low < high) {
            int middle = (low + high) / 2;
            if (nums[middle] == nums[middle + 1]) {
                int duplicate = nums[middle];
                int index = middle + 2;
                while (index <= high && nums[index] == duplicate) index++;
                if (index > high) {
                    high = middle;
                    continue;
                } else middle = index - 1;
            }
            if (nums[middle] < nums[middle + 1]) {
                if (nums[middle] < nums[high]) high = middle;
                else low = middle;
            } else return nums[middle + 1];
        }
        return nums[low];
    }
}
