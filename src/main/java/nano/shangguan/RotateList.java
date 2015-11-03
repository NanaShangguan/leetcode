package nano.shangguan;

import util.ListNode;

/**
 * Created by Nano on 2015/10/19.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head != null) {
            //获得链表长度
            int len = 0;
            ListNode node = head;
            while (node != null) {
                len++;
                node = node.next;
            }
            k = k % len;
            //寻找pivot的prev位置
            ListNode fast = head, slow = null, prev = null;
            k = -k;
            while (fast != null) {
                if (k >= 0) {
                    if (slow == null) slow = head;
                    else slow = slow.next;
                }
                prev = fast;
                fast = fast.next;
                k++;
            }
            if (slow != null && slow != prev) {
                prev.next = head;
                head = slow.next;
                slow.next = null;
            }
        }
        return head;
    }
}
