package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

/**
 * Created by Nano on 2015/9/9.
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return numberString(root, "");
    }

    public int numberString(TreeNode node, String str) {
        str += node.val;
        if (node.left == null && node.right == null) {
            return Integer.parseInt(str);
        }
        int sum = 0;
        if (node.left != null) sum += numberString(node.left, str);
        if (node.right != null) sum += numberString(node.right, str);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new SumRootToLeafNumbers().sumNumbers(
                BinaryTreeFactory.getBinaryTree("1 2 # # 3 # #")
        ));
    }
}
