package nano.shangguan;

/**
 * Created by Nano on 2015/8/31.
 */
public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return check(root.left, root.right);
    }

    private boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val == node2.val) {
            return check(node1.left, node2.right) && check(node1.right, node2.left);
        } else return false;
    }
}
