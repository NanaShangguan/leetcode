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
//        return solution1(root, sum);
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<List<Integer>> path = new ArrayList<List<Integer>>();
        solution2(root, sum, list, path);
        return path;
    }

    private List<List<Integer>> solution1(TreeNode root, int sum) {
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

    private void solution2(TreeNode node, int sum, List<Integer> list, List<List<Integer>> path) {
        if (node == null) return;
        //如果是叶子结点，计算sum，相等则copy一份放入list，返回上一层
        if (node.left == null && node.right == null) {
            if (node.val == sum) {
                ArrayList<Integer> copy = new ArrayList<Integer>();
                for (int num : list) {
                    copy.add(num);
                }
                copy.add(node.val);
                path.add(copy);
            }
        } else {
            list.add(node.val);
            if (node.left != null) solution2(node.left, sum - node.val, list, path);
            if (node.right != null) solution2(node.right, sum - node.val, list, path);
            //移除刚添加的值
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new PathSumII().pathSum(
                BinaryTreeFactory.getBinaryTree("5 4 11 7 # # 2 # # # 8 13 # # 4 5 # # 1 # #")
//                null
                , 22
        ));
    }
}
