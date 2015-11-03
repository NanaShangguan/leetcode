package nano.shangguan;

import util.ListNode;

/**
 * Created by Nano on 2015/10/21.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = null;
        int len = 0;
        while (fast != null) {
            len++;
            if (fast == slow) {
                slow = head;
                fast = fast.next.next;
                //是个环链表
                if (fast != slow) {
                    while (slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                }
                return slow;
            }
            if (len % 2 == 1) {
                if (slow == null) slow = head;
                else slow = slow.next;
            }
            fast = fast.next;
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = head;
//        head.next.next = new ListNode(0);
//        head.next.next.next = new ListNode(-4);
//        head.next.next.next.next = new ListNode(-5);
//        head.next.next.next.next.next = head;
        System.out.println(new LinkedListCycleII().detectCycle(head));
    }
}
