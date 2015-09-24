package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

import java.util.*;

/**
 * Created by Nano on 2015/9/23.
 */
public class LowestCommonAncestorOfABinaryTree {
    private boolean isPFinished = false;
    private boolean isQFinished = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*µÝ¹é2
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return (left == null) ? right : left;
        */

        List<TreeNode> pathToP = new ArrayList<TreeNode>();
        List<TreeNode> pathToQ = new ArrayList<TreeNode>();
        getRootToNodePath(root, p, q, pathToP, pathToQ);

        int i = 0;
        while (i < pathToP.size()
                && i < pathToQ.size()
                && pathToP.get(i) == pathToQ.get(i)) { i++; }
        return pathToP.get(i - 1);
    }

    //µÝ¹é1 Çópath
    private void getRootToNodePath(TreeNode root
            , TreeNode p, TreeNode q, List<TreeNode> listP, List<TreeNode> listQ) {
        if ((isPFinished && isQFinished) || root == null) return;
        if (root == p) {
            listP.add(root);
            isPFinished = true;
        } else if (root == q) {
            listQ.add(root);
            isQFinished = true;
        }
        if (!isPFinished) listP.add(root);
        if (!isQFinished) listQ.add(root);
        getRootToNodePath(root.left, p, q, listP, listQ);
        getRootToNodePath(root.right, p, q, listP, listQ);
        if (!isPFinished) listP.remove(listP.size() - 1);
        if (!isQFinished) listQ.remove(listQ.size() - 1);
    }

    /*stack + map
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
    }*/

    public static void main(String[] args) {
        System.out.println(new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(
                BinaryTreeFactory.getBinaryTree("1 2 # # #")
                , new TreeNode(1)
                , new TreeNode(2)
        ).val);
    }
}
