package nano.shangguan;

import util.ListNode;

/**
 * Created by Nano on 2015/10/19.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = null;
        int len = 0;
        while (fast != null) {
            len++;
            if (fast == slow) return true;
            if (len % 2 == 1) {
                if (slow == null) slow = head;
                else slow = slow.next;
            }
            fast = fast.next;
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        System.out.println(new LinkedListCycle().hasCycle(head));
    }
}
