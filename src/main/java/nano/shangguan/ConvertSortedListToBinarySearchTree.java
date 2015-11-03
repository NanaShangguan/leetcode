package nano.shangguan;

import util.ListNode;
import util.TreeNode;

/**
 * Created by Nano on 2015/9/21.
 * 红黑树
 */
public class ConvertSortedListToBinarySearchTree {
    private ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        //get Linklist's length
        this.head = head;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return getBBST(0, len - 1);
    }
    private TreeNode getBBST(int start, int end) {
        if (start > end) return null;
        int middle = (start + end) / 2;
        TreeNode left = getBBST(start, middle - 1);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        TreeNode right = getBBST(middle + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(new ConvertSortedListToBinarySearchTree().sortedListToBST(head));
    }
}
