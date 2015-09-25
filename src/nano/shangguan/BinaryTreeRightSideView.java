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
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                Queue<TreeNode> newQueue = new LinkedList<TreeNode>();
                TreeNode top = null;
                while (!queue.isEmpty()) {
                    top = queue.poll();
                    if (top.left != null) newQueue.add(top.left);
                    if (top.right != null) newQueue.add(top.right);
                }
                list.add(top.val);
                queue = newQueue;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeRightSideView().rightSideView(
                BinaryTreeFactory.getBinaryTree("#")
        ));
    }
}
