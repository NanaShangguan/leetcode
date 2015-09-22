package nano.shangguan;

import util.BinaryTreeFactory;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2015/9/22.
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root != null) {
            if (root.left == null && root.right == null) {
                if (sum == root.val)  {
                    ArrayList<Integer> list1 = new ArrayList<Integer>();
                    list1.add(root.val);
                    list.add(list1);
                }
            } else {
                if (root.left != null) list.addAll(pathSum(root.left, sum - root.val));
                if (root.right != null) list.addAll(pathSum(root.right, sum - root.val));
                for (List<Integer> path : list) {
                    path.add(0, root.val);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(new PathSumII().pathSum(
                BinaryTreeFactory.getBinaryTree("5 4 11 7 # # 2 # # # 8 13 # # 4 5 # # 1 # #")
                , 22
        ));
    }
}
