package nano.shangguan;

import util.ListNode;

/**
 * Created by Nano on 2015/10/19.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head != null) {
            ListNode prev = null, n1 = head, n2 = head.next;
            int len = 1;
            while (n2 != null) {
                len++;
                if (len % 2 == 0) {
                    //需要进行交换
                    if (prev != null) {
                        prev.next = n2;
                        prev = n2;
                    } else {
                        head = n2;
                    }
                    n1.next = n2.next;
                    n2.next = n1;
                    n2 = n1.next;
                } else {
                    prev = n1;
                    n1 = n1.next;
                    n2 = n2.next;
                }
            }
        }
        return head;
    }
}
