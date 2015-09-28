package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Nano on 2015/9/28.
 * 题目转换：在一个升序数组中，有两个数字调换了位置，找出这两个数字
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        if (root != null) {
            TreeNode element1 = null, element2 = null, prev = null, top = null;
            Stack<TreeNode> stack = new Stack<TreeNode>();
            List<TreeNode> visited = new ArrayList<TreeNode>();
            stack.push(root);

            while (!stack.isEmpty()) {
                top = stack.peek();
                while (!visited.contains(top) && top.left != null) {
                    visited.add(top);
                    stack.push(top.left);
                    top = stack.peek();
                }
                top = stack.pop();
                if (top.right != null) stack.push(top.right);
                if (prev == null) prev = top;
                else {
                    if (element1 == null) {
                        if (prev.val > top.val) element1 = prev;
                    } else {
                        if (top.val > element1.val) {
                            element2 = prev;
                            break;
                        }
                    }
                }
                prev = top;
            }

            //交换两个元素
            //当第二个元素位于中序序列最后一位时特殊处理
            if (element1 != null && element2 == null) element2 = top;
            if (element1 != null && element2 != null) {
                int temp = element1.val;
                element1.val = element2.val;
                element2.val = temp;
            }
        }
    }

    public static void main(String[] args) {
//        TreeNode root = BinaryTreeFactory.getBinaryTree("5 3 2 1 # # # 4 # # 7 6 # # 8 # #");
        TreeNode root = BinaryTreeFactory.getBinaryTree("0 1 # # #");
        new RecoverBinarySearchTree().recoverTree(root);
        System.out.println(root);
    }
}
