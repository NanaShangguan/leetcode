package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Nano on 2015/9/25.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            int level = 0;
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<Integer>();
                Queue<TreeNode> newQueue = new LinkedList<TreeNode>();
                while (!queue.isEmpty()) {
                    TreeNode top = queue.poll();
                    if (top.left != null) newQueue.add(top.left);
                    if (top.right != null) newQueue.add(top.right);
                    if (level % 2 == 0) list.add(top.val);
                    else list.add(0, top.val);
                }
                lists.add(list);
                queue = newQueue;
                level++;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(
                BinaryTreeFactory.getBinaryTree("#")
        ));
    }
}
