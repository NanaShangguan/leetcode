package nano.shangguan;

import util.TreeNode;

/**
 * Created by Nano on 2015/9/8.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }

    /**
     * �жϸ����Ƿ�Ϊƽ������� & �����������
     * @param node root
     * @return -1��������ƽ���  >-1: �������
     */
    private int check(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = check(node.left);
        int rightDepth = check(node.right);
        //�������������������ƽ�������
        if (leftDepth != -1 && rightDepth != -1 &&
                leftDepth - rightDepth >= -1 && leftDepth - rightDepth <= 1) {
            return Math.max(leftDepth, rightDepth) + 1;
        }
        return -1;
    }
}
