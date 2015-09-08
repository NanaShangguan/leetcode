package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Nano on 2015/9/7.
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Queue<TreeNode> newQueue = new LinkedList<TreeNode>();
                List<Integer> layer = new ArrayList<Integer>();
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    layer.add(node.val);
                    if (node.left != null) newQueue.add(node.left);
                    if (node.right != null) newQueue.add(node.right);
                }
                list.add(layer);
                queue = newQueue;
            }
        }
        return list;
    }
//        3
//       / \
//      9  20
//        /  \
//       15   7
    public static void main(String[] args) {
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(
                BinaryTreeFactory.getBinaryTree("3 9 # # 20 15 # # 7 # #")
        ));
    }
}
