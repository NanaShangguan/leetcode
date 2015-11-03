package nano.shangguan;

import util.TreeNode;

/**
 * Created by Nano on 2015/8/31.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return check(p, q);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val) {
            return check(p.left, q.left) && check(p.right, q.right);
        } else return false;
    }
}
