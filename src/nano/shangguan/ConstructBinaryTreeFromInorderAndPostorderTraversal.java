package nano.shangguan;

import util.TreeNode;

/**
 * Created by Nano on 2015/9/25.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildBinaryTree(inorder, 0, inorder.length - 1
                , postorder, 0, postorder.length - 1);
    }

    private TreeNode buildBinaryTree(int[] inorder, int inStart, int inEnd
            , int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) return null;
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
        int leftOrderLength = 0;
        while (inorder[inStart + leftOrderLength] != rootValue) { leftOrderLength++; }
        root.left = buildBinaryTree(inorder, inStart, inStart + leftOrderLength - 1
                , postorder, postStart, postStart + leftOrderLength - 1);
        root.right = buildBinaryTree(inorder, inStart + leftOrderLength + 1, inEnd
                , postorder, postStart + leftOrderLength, postEnd - 1);
        return root;
    }
}
