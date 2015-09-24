package nano.shangguan;

import util.TreeNode;

/**
 * Created by Nano on 2015/9/22.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return getBST(nums, 0, nums.length - 1);
    }

    private TreeNode getBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int middle = (start + end) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = getBST(nums, start, middle - 1);
        node.right = getBST(nums, middle + 1, end);
        return node;
    }
}
