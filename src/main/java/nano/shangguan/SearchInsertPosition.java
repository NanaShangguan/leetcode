package nano.shangguan;

/**
 * Created by Nano on 2015/4/27.
 * ¶þ·Ö·¨
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int front = 0, back = nums.length - 1;
        while (front <= back) {
            int middle = (front + back) / 2;
            if (target > nums[middle])
                front = middle + 1;
            else if (target < nums[middle])
                back = middle - 1;
            else return middle;
        }

        return front;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 0));
    }
}
