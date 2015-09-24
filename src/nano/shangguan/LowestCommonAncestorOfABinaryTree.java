package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

import java.util.*;

/**
 * Created by Nano on 2015/9/23.
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode>[] paths = getRootToNodePath(root, p, q);
        List<TreeNode> pathToP = paths[0];
        List<TreeNode> pathToQ = paths[1];
        int i = 0;
        while (i < pathToP.size()
                && i < pathToQ.size()
                && pathToP.get(i) == pathToQ.get(i)) { i++; }
        return pathToP.get(i - 1);
    }

    private List<TreeNode>[] getRootToNodePath(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode>[] list = new List[2];
        list[0] = new ArrayList<TreeNode>();
        list[1] = new ArrayList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
        map.put(root, root);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top == p || top == q) {
                List<TreeNode> path;
                if (top == p) path = list[0];
                else path = list[1];
                path.add(top);
                TreeNode n = top;
                while (n != root) {
                    n = map.get(n);
                    path.add(0, n);
                }
                if (list[0].size() != 0 && list[1].size() != 0) break;
            }
            if (top.right != null) {
                stack.push(top.right);
                map.put(top.right, top);
            }
            if (top.left != null) {
                stack.push(top.left);
                map.put(top.left, top);
            }
        }
        return list;
        /* ตÝน้
        if (root == null) return null;
        if (root.val == node.val) {
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            list.add(root);
            return list;
        }
        List<TreeNode> leftPath = getRootToNodePath(root.left, node);
        if (leftPath == null) {
            List<TreeNode> rightPath = getRootToNodePath(root.right, node);
            if (rightPath == null) return null;
            rightPath.add(0, root);
            return rightPath;
        }
        leftPath.add(0, root);
        return leftPath;
        */
    }

    public static void main(String[] args) {
        System.out.println(new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(
                BinaryTreeFactory.getBinaryTree("1 2 # # #")
                , new TreeNode(1)
                , new TreeNode(2)
        ).val);
    }
}
