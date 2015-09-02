package util;

/**
 * Created by Nano on 2015/8/31.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return getString(this);
    }

    private String getString(TreeNode node) {
        if (node == null) return "#";
        return node.val + " " + getString(node.left) + " " + getString(node.right);
    }
}
