package nano.shangguan;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Nano on 2015/9/8.
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        List<List<Integer>> newList = new ArrayList<List<Integer>>();
        for (int i = list.size() - 1; i >= 0; i--) {
            newList.add(list.get(i));
        }
        return newList;
    }
}
