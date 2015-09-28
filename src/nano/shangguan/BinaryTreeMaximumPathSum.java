package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

/**
 * Created by Nano on 2015/9/28.
 */
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        int max = Integer.MIN_VALUE;
        if (root.left != null) {
            int leftMax = maxPathSum(root.left);

        }

        int rightMax = maxPathSum(root.right);
        return Math.max(leftMax + root.val + rightMax
                , Math.max(leftMax + root.val
                , Math.max(rightMax + root.val
                , Math.max(root.val
                , Math.max(leftMax, rightMax)))));
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(
                BinaryTreeFactory.getBinaryTree("-2 1 # # #")
        ));
    }
}
