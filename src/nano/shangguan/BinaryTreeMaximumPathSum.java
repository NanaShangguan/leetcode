package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2015/9/28.
 */
public class BinaryTreeMaximumPathSum {

    private List<Integer> list = new ArrayList<Integer>();

    public int maxPathSum(TreeNode root) {
        list.add(maxPathSumAcrossRoot(root));
        if (list.size() != 0) {
            int max = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (max < list.get(i))
                    max = list.get(i);
            }

            return max;
        }
        return 0;
    }

    /**
     * 返回经过根结点的（但不包括从左到根再到右的path sum）的path sum中的最大值
     * 并保存其他路径中的最大值
     * @param root
     * @return
     */
    public int maxPathSumAcrossRoot(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        int leftMax = maxPathSumAcrossRoot(root.left);
        int rightMax = maxPathSumAcrossRoot(root.right);

        int max;

        //添加除跨过根路径的其他路径中和的最大值
        if (root.left != null && root.right != null) {
            list.add(Math.max(leftMax, Math.max(rightMax, leftMax + root.val + rightMax)));
            max = Math.max(root.val, Math.max(root.val + leftMax, root.val + rightMax));
        }
        else if (root.left != null && root.right == null) {
            list.add(leftMax);
            max = Math.max(root.val, root.val + leftMax);
        }
        else {
            list.add(rightMax);
            max = Math.max(root.val, root.val + rightMax);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(
                BinaryTreeFactory.getBinaryTree("1 2 # # #")
        ));
    }
}
