package util;

import java.util.Stack;

/**
 * Created by Nano on 2015/9/1.
 */
public class BinaryTreeFactory {
    /**
     * 二叉树的反序列化
     * @param serializedString 二叉树先序遍历得到的序列化字符串
     * @return 根节点
     */
    public static TreeNode getBinaryTree(String serializedString) {
        String[] arr = serializedString.split(" ");
        Stack<String> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            stack.push(arr[i]);
        }

    }

    private static TreeNode generate(TreeNode node, Stack<String> stack) {
        String value = stack.pop();
        if (value.equals("#"))
            return null;
        node.val = Integer.parseInt(value);
    }
}
