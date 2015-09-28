package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Nano on 2015/9/27.
 */
public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<TreeNode>();
    private List<TreeNode> visited = new ArrayList<TreeNode>();

    public BSTIterator(TreeNode root) {
        if (root != null) stack.push(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            while (!visited.contains(top) && top.left != null) {
                visited.add(top);
                stack.push(top.left);
                top = stack.peek();
            }
            top = stack.pop();
            if (top.right != null) {
                stack.push(top.right);
            }
            return top.val;
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeFactory.getBinaryTree("12 5 2 # # 9 # # 18 15 # 17 16 # # # 19 # #");
        BSTIterator it = new BSTIterator(root);
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
