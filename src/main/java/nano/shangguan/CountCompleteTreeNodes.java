package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

/**
 * Created by Nano on 2015/9/25.
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        return count(root, -1, -1);
    }

    private int count(TreeNode root, int leftHeight, int rightHeight) {
        if (root == null) return 0;
        if (leftHeight == -1) leftHeight = leftHeight(root);
        if (rightHeight == -1) rightHeight = rightHeight(root);
        if (leftHeight == rightHeight) {
            //满二叉树  2的n次方-1
            int i = 1;
            int count = 1;
            while (i <= leftHeight) {
                count *= 2;
                i++;
            }
            return count - 1;
        } else return count(root.left, leftHeight - 1, -1)
                + 1 + count(root.right, -1, rightHeight - 1);
    }

    private int leftHeight(TreeNode node) {
        int i = 1;
        while (node.left != null) {
            node = node.left;
            i++;
        }
        return i;
    }

    private int rightHeight(TreeNode node) {
        int i = 1;
        while (node.right != null) {
            node = node.right;
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new CountCompleteTreeNodes().countNodes(
                BinaryTreeFactory.getBinaryTree("1 2 4 8 # # 9 # # 5 10 # # 11 # # 3 6 12 # # # 7 # #")
        ));
    }
}
