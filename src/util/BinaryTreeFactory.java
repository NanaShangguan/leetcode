package util;

import java.util.Stack;

/**
 * Created by Nano on 2015/9/1.
 */
public class BinaryTreeFactory {
    /**
     * �������ķ����л�
     * @param serializedString ��������������õ������л��ַ���
     * @return ���ڵ�
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
