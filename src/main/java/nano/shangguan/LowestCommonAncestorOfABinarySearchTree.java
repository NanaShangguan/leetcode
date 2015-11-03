package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

/**
 * Created by Nano on 2015/9/7.
 */
public class LowestCommonAncestorOfABinarySearchTree {
//         _______6______
//        /              \
//     ___2__          ___8__
//    /      \        /      \
//   0       _4_      7       9
//          /   \
//         3     5
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return search(root, p, q);
    }

    /**
     * 1. �������һ���ڵ��ֵ���ڵ�ǰ��root�ڵ㣬����p��q�־���root���࣬˵��rootΪ�乫�����ȣ�����root
     * 2. ���p��q��ֵ��С��root��˵��p��q��root���������ϣ��ݹ�
     * 3. ���p��q��ֵ������root��˵��p��q��root���������ϣ��ݹ�
     * @param root
     * @param p
     * @param q
     * @return
     */
    private TreeNode search(TreeNode root, TreeNode p, TreeNode q) {
        if ((p.val == root.val || q.val == root.val) ||
                (p.val < root.val && q.val > root.val) ||
                (q.val < root.val && p.val > root.val)) return root;
        if (p.val < root.val && q.val < root.val)
            return search(root.left, p, q);
        if (p.val > root.val && q.val > root.val)
            return search(root.right, p, q);
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new LowestCommonAncestorOfABinarySearchTree().lowestCommonAncestor(
                BinaryTreeFactory.getBinaryTree("2 1 # # 3 # #"), new TreeNode(3), new TreeNode(1)
        ).val);
    }
}
