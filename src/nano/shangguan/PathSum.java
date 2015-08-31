package nano.shangguan;

import util.TreeNode;

/**
 * Created by Nano on 2015/8/31.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return traverse(root, sum, 0);
    }

    private boolean traverse(TreeNode p, int sum, int curSum) {
        curSum += p.val;
        if (p.left == null && p.right == null) {
            if (curSum == sum) return true;
            else return false;
        }
        if ((p.left != null && traverse(p.left, sum, curSum))
                || (p.right != null && traverse(p.right, sum, curSum)))
            return true;
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(new PathSum().hasPathSum(root, 22));
    }
}
