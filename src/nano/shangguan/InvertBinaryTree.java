package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

/**
 * Created by Nano on 2015/9/7.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(left);
        }
        return root;
    }

//        4
//      /   \
//     2     7
//    / \   / \
//   1   3 6   9
    public static void main(String[] args) {
        System.out.println(new InvertBinaryTree().invertTree(
                BinaryTreeFactory.getBinaryTree("4 2 1 0 # # # 3 # # 7 6 # # 9 # #")
        ));
    }
}
