package nano.shangguan;

import util.ListNode;

/**
 * Created by Nano on 2015/10/20.
 */
public class ReorderList {
    /**
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
     * 后半段反转，与前半段合并
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head != null) {
            ListNode fast = head, slow = head;
            int len = 0;
            while (fast != null) {
                len++;
                if (len != 1 && len % 2 == 1) slow = slow.next;
                fast = fast.next;
            }
            ListNode subList = slow.next;
            slow.next = null;
            //反转后半段
            if (subList != null) {
                ListNode n1 = subList, n2 = subList.next;
                while (n2 != null) {
                    ListNode nextN2 = n2.next;
                    n2.next = n1;
                    if (n1 == subList) n1.next = null;
                    n1 = n2;
                    n2 = nextN2;
                }
                subList = n1;
                //合并两段
                n1 = head;
                n2 = subList;
                //n2为长度较短的一个子序列
                while (n2 != null) {
                    ListNode nextN2 = n2.next;
                    n2.next = n1.next;
                    n1.next = n2;
                    n1 = n2.next;
                    n2 = nextN2;
                }
            }
        }


    }
}
