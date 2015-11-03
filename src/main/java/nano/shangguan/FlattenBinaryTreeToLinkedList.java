package nano.shangguan;

import util.TreeNode;

import java.util.Stack;

/**
 * Created by Nano on 2015/9/24.
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root.right != null) stack.push(root.right);
        if (root.left != null) stack.push(root.left);
        TreeNode prev = root;

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            prev.right = top;
            prev.left = null;
            prev = top;
            if (top.right != null) stack.push(top.right);
            if (top.left != null) stack.push(top.left);
        }
    }
}
