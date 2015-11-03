package nano.shangguan;

/**
 * Created by Nano on 2015/10/12.
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int[] range = { -1, -1 };
        while (low <= high) {
            int middle = (low + high) / 2;
            if (nums[middle] == target) {
                int copyHigh = high;
                //从[low, middle)开始找左边界
                range[0] = middle;
                high = middle - 1;
                while (low <= high) {
                    int mdl = (low + high) / 2;
                    if (nums[mdl] == target) {
                        //更新区间左边界值
                        range[0] = mdl;
                        //继续向左扩展
                        high = mdl - 1;
                    } else {
                        low = mdl + 1;
                    }
                }
                //在(middle, high]中找右边界
                range[1] = middle;
                low = middle + 1;
                high = copyHigh;
                while (low <= high) {
                    int mdl = (low + high) / 2;
                    if (nums[mdl] == target) {
                        range[1] = mdl;
                        low = mdl + 1;
                    } else {
                        high = mdl - 1;
                    }
                }
                break;
            } else if (nums[middle] > target)
                high = middle - 1;
            else low = middle + 1;
        }
        return range;
    }

    public static void main(String[] args) {
        int[] range = new SearchForARange().searchRange(
                new int[]{5, 7, 7, 8, 8, 10}
                , 10
        );
        for (int num : range) {
            System.out.print(num + " ");
        }
    }
}
