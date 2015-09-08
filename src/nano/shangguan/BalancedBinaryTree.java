package nano.shangguan;

import util.TreeNode;

/**
 * Created by Nano on 2015/9/8.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }

    /**
     * 判断该树是否为平衡二叉树 & 计算树的深度
     * @param node root
     * @return -1：树不是平衡的  >-1: 树的深度
     */
    private int check(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = check(node.left);
        int rightDepth = check(node.right);
        //如果左右两个子树都是平衡二叉树
        if (leftDepth != -1 && rightDepth != -1 &&
                leftDepth - rightDepth >= -1 && leftDepth - rightDepth <= 1) {
            return Math.max(leftDepth, rightDepth) + 1;
        }
        return -1;
    }
}
