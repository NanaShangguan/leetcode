package nano.shangguan;

import util.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nano on 2015/9/10.
 * 该解法不满足[常数空间复杂度]的要求，详见 PopulatingNextRightPointersInEachNodeII
 */
public class PopulatingNextRightPointersInEachNode {
    /**
     *
     * @param root 满二叉树
     */
    public void connect(TreeLinkNode root) {
        if (root != null) {
            Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Queue<TreeLinkNode> newQueue = new LinkedList<TreeLinkNode>();
                while (!queue.isEmpty()) {
                    TreeLinkNode node = queue.poll();
                    if (queue.isEmpty()) node.next = null;
                    else node.next = queue.peek();
                    if (node.left != null) newQueue.add(node.left);
                    if (node.right != null) newQueue.add(node.right);
                }
                queue = newQueue;
            }
        }
    }
}
