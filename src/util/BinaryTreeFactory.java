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
        Stack<String> stack = new Stack<String>();
        for (int i = arr.length - 1; i >= 0; i--) {
            stack.push(arr[i]);
        }
        TreeNode root = generate(stack);
        return root;
    }

    private static TreeNode generate(Stack<String> stack) {
        String value = stack.pop();
        if (value.equals("#"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = generate(stack);
        node.right = generate(stack);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeFactory.getBinaryTree("30 10 50 # # # 20 45 # # 35 # #");
        System.out.println(root);
    }
}
