package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Nano on 2015/9/24.
 */
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        return recursiveSolution(root, k);
    }

    private int recursiveSolution(TreeNode node, int k) {
        List<Integer> list = new ArrayList<Integer>();
        find(node, k, list);
        return list.get(k - 1);
    }

    private void find(TreeNode node, int k, List<Integer> list) {
        if (list.size() == k || node == null) return;
        find(node.left, k, list);
        if (list.size() != k) list.add(node.val);
        if (list.size() != k) find(node.right, k, list);
    }

    private int stackSolution(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int i = 1;
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            while (top.left != null) {
                stack.push(top.left);
                top.left = null;
                top = stack.peek();
            }
            top = stack.pop();
            if (i == k) return top.val;
            if (top.right != null) {
                stack.push(top.right);
            }
            i++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new KthSmallestElementInBST().kthSmallest(
                BinaryTreeFactory.getBinaryTree("6 5 4 3 2 1 # # # # # # 7 # #")
                ,6
        ));
    }
}
