package nano.shangguan;

import util.ListNode;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2015/9/21.
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        //listNode to Array
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return getBBST(0, list.size() - 1, list);
    }

    private TreeNode getBBST(int start, int end, List<Integer> list) {
        if (start > end) return null;
        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(middle));
        root.left = getBBST(start, middle - 1, list);
        root.right = getBBST(middle + 1, end, list);
        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(new ConvertSortedListToBinarySearchTree().sortedListToBST(head));
    }
}
