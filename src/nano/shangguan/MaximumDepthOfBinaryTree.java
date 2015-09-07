package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nano on 2015/9/6.
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int length = 0;
        while (!queue.isEmpty()) {
            length++;
            Queue<TreeNode> newQueue = new LinkedList<TreeNode>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
//                if (node.left == null && node.right == null) return length;
                if (node.left != null) newQueue.add(node.left);
                if (node.right != null) newQueue.add(node.right);
            }
            queue = newQueue;
        }
        return length;
    }

    public static void main(String[] args) {
//               30
//             /    \
//            10    20
//           /     /  \
//          50    45  35
//         /
//        23
//        3 9 20 null null 15 7
        System.out.println(
                new MaximumDepthOfBinaryTree().maxDepth(
                        BinaryTreeFactory.getBinaryTree("30 10 50 23 # # # # 20 45 # # 35 # #")
                )
        );
    }
}
