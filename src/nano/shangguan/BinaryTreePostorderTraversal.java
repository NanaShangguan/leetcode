package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Nano on 2015/9/28.
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            List<TreeNode> visited = new ArrayList<TreeNode>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode top = stack.peek();
                while ((top.left != null || top.right != null) && !visited.contains(top)) {
                    visited.add(top);
                    if (top.right != null) stack.push(top.right);
                    if (top.left != null) stack.push(top.left);
                    top = stack.peek();
                }
                list.add(stack.pop().val);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreePostorderTraversal().postorderTraversal(
                BinaryTreeFactory.getBinaryTree("3 1 # 2 # # #")
        ));
    }
}
