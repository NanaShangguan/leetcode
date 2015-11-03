package nano.shangguan;

import util.TreeNode;

/**
 * Created by Nano on 2015/5/26.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildBinaryTree(preorder, 0, preorder.length - 1
                , inorder, 0, inorder.length - 1);
    }

    private TreeNode buildBinaryTree(int[] preorder, int preStart, int preEnd
            , int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
        int leftOrderLength = 0;
        while (inorder[inStart + leftOrderLength] != rootValue) { leftOrderLength++; }
        root.left = buildBinaryTree(preorder, preStart + 1, preStart + leftOrderLength
                , inorder, inStart, inStart + leftOrderLength - 1);
        root.right = buildBinaryTree(preorder, preStart + leftOrderLength + 1, preEnd
                , inorder, inStart + leftOrderLength + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new ConstructBinaryTreeFromPreorderAndInorderTraversal()
                .buildTree(new int[]{ 1 }
                        , new int[]{ 1 }));
    }
}
