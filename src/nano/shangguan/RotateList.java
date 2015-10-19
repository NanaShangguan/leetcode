package nano.shangguan;

import util.ListNode;

/**
 * Created by Nano on 2015/10/19.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head != null) {
            ListNode fast = head, slow = null;
            k = -k;
            while (fast.next != null) {
                k++;
                if (k >= 0) {
                    if (slow == null) slow = head;
                    else slow = slow.next;
                }
                fast = fast.next;
            }
            if (slow != null) {
                fast.next = head;
                head = slow.next;
                slow.next = null;
            }
        }
        return head;
    }
}
