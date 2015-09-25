package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Nano on 2015/9/25.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root != null) {
            List<TreeNode> visited = new ArrayList<TreeNode>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode top = stack.peek();
                while (!visited.contains(top) && top.left != null) {
                    visited.add(top);
                    stack.push(top.left);
                    top = stack.peek();
                }
                top = stack.pop();
                list.add(top.val);
                if (top.right != null)
                    stack.push(top.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(
                BinaryTreeFactory.getBinaryTree("1 # #")
        ));
    }
}