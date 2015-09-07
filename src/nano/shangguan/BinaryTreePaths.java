package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2015/9/7.
 * Depth First Search
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        depthFirstSearch(root, "", list);
        return list;
    }

    private void depthFirstSearch(TreeNode node, String path, List<String> list) {
        if (node == null) return;
        //增加path
        if (!path.equals("")) path += "->";
        path += node.val;
        //检查左右子节点
        if (node.left == null && node.right == null) {
            list.add(path);
            return;
        }
        if (node.left != null) depthFirstSearch(node.left, path, list);
        if (node.right != null) depthFirstSearch(node.right, path, list);
    }
//        1
//      /   \
//     2     3
//      \
//       5
    public static void main(String[] args) {
        System.out.println(new BinaryTreePaths().binaryTreePaths(
                BinaryTreeFactory.getBinaryTree("1 # #")
        ));
    }
}
