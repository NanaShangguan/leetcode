package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Nano on 2015/9/25.
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode top = stack.pop();
                list.add(top.val);
                if (top.right != null) stack.push(top.right);
                if (top.left != null) stack.push(top.left);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreePreorderTraversal().preorderTraversal(
                BinaryTreeFactory.getBinaryTree("#")
        ));
    }
}
