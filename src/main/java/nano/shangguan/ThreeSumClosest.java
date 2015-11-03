package nano.shangguan;

/**
 * Created by Nano on 2015/5/22.
 * 题目分析：
 * 先对数组排序，然后枚举最小的数n1，对于第二和三个数，用两个索引l和r从两端往中间夹击找，找最接近target - n1的两个数，可以通过“求在一个数组中找两个数，使这两个数的和最接近目标整数newTarget”。
 * 正确性说明，假设排好序的数组为S1,S2...Si...Sj...Sn，假定最终Si + Sj最接近目标整数newTarget
 * （1）若Si + Sj < newTarget 那么Si-k + Sj  < newTarget，Si + Sj+k  > newTarget（如果：Si + Sj+k  < newTarget，那么Si和Sj不是最优值）
 * 当l先到达i时，Si + Sj+k > newTarget，r会减小至j；当r先到达j时，Si-k + Sj < newTarget，l会增加至i。
 * （2）若Si + Sj > newTarget 那么Si + Sj+k  > newTarget，Si-k + Sj  < newTarget（如果：Si-k + Sj  > newTarget，那么Si和Sj不是最优值）
 * 当l先到达i时，Si + Sj+k > newTarget，r会减小至j；当r先到达i时，Si-k + Sj < newTarget，l会增加至i。
 * 所以总会找到最优值
 * 时间复杂度：O（n^2）
 */
public class ThreeSumClosest {

    // 时间复杂度：O（n^2）
    public int threeSumClosest(int[] nums, int target) {
        quickSort(nums);

        int min_offset = target - nums[0] - nums[1] - nums[2];
        for (int i = 0; i < nums.length; i++) {
            // 确定index最小的一个数，遍历[i, len - 1]
            for (int low = i + 1, high = nums.length - 1; low < high; ) {
                int new_offset = target - nums[i] - nums[low] - nums[high];
                if (Math.abs(min_offset) > Math.abs(new_offset))
                    min_offset = new_offset;
                if (new_offset < 0) high--;
                else if (new_offset > 0) low++;
                else return target;
            }
        }

        return target - min_offset;
    }

    public void quickSort(int[] nums) {
        divide(nums, 0 , nums.length - 1);
    }
    public void divide(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int target = nums[start];
        boolean isHigh = true;
        int i = start, j = end;

        while (i < j) {
            if (isHigh) {
                if (nums[j] >= target) j--;
                else {
                    nums[i++] = nums[j];
                    isHigh = false;
                }
            } else {
                if (nums[i] <= target) i++;
                else {
                    nums[j--] = nums[i];
                    isHigh = true;
                }
            }
        }

        nums[i] = target;
        divide(nums, start, i - 1);
        divide(nums, i + 1, end);
    }

    public static void main (String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{1,1,1,0}, -100));
    }
}
