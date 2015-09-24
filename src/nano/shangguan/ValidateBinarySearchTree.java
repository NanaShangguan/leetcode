package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2015/9/8.
 */
public class ValidateBinarySearchTree {
    /**
     * 根结点的值小于右子树上任意结点的值，大于左子树任意结点的值，且左右子树为二叉搜索树
     * @param root 根结点
     * @return 是否是二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
//        return check(root) != null;   //solution1
        //solution2
        List<Integer> inOrder = new ArrayList<Integer>();
        inOrderTraversal(root, inOrder);
        for (int i = 1; i < inOrder.size(); i++) {
            if (inOrder.get(i) <= inOrder.get(i - 1))
                return false;
        }
        return true;
    }

    /**
     * 中序遍历是递增序列
     * @param root
     * @param order
     */
    private void inOrderTraversal(TreeNode root, List<Integer> order) {
        if (root.left != null) inOrderTraversal(root.left, order);
        order.add(root.val);
        if (root.right != null) inOrderTraversal(root.right, order);
    }

    /**
     * 求此树的最值
     * @param node 根结点root
     * @return null=非二叉树 int[0]最小值 int[1]最大值
     */
    private int[] check(TreeNode node) {
        int[] value = new int[]{ node.val, node.val };
        //如果结点是叶结点，返回结点值
        if (node.left == null && node.right == null)
            return value;
        if (node.left != null) {
            int[] left = check(node.left);
            if (left != null && left[1] < node.val)
                value[0] = left[0];
            else return null;
        }
        if (node.right != null) {
            int[] right = check(node.right);
            if (right != null && right[0] > node.val)
                value[1] = right[1];
            else return null;
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(new ValidateBinarySearchTree().isValidBST(
                BinaryTreeFactory.getBinaryTree("2 1 # # 5 3 # 4 # # #")
//                BinaryTreeFactory.getBinaryTree("2 1 # # 3 # #")
        ));
    }
}
