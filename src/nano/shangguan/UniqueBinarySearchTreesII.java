package nano.shangguan;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2015/9/9.
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                List<TreeNode> left = generate(start, i - 1);
                List<TreeNode> right = generate(i + 1, end);
                int leftSize = left.size();
                int rightSize = right.size();
                for (int p = 0; p < leftSize; p++) {
                    for (int q = 0; q < rightSize; q++) {
                        TreeNode node = new TreeNode(i);
                        node.left = left.get(p);
                        node.right = right.get(q);
                        list.add(node);
                    }
                }
            }
        } else list.add(null);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTreesII().generateTrees(2));
    }
}
