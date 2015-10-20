package nano.shangguan;

import util.LinkedListFactory;
import util.ListNode;

/**
 * Created by Nano on 2015/10/20.
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head, last = null;
        head = null;
        while (node != null) {
            ListNode cur = node;
            int value = cur.val;
            int count = 1;
            node = node.next;
            while (node != null && node.val == value) {
                node = node.next;
                count++;
            }
            if (count == 1) {
                if (head == null) {
                    head = cur;
                    last = cur;
                } else {
                    last.next = cur;
                    last = last.next;
                }
                last.next = null;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedListII().deleteDuplicates(
                LinkedListFactory.getListFromIntArray(new int[]{1, 2, 2})
        ));
    }
}
