package nano.shangguan;

import util.ListNode;

/**
 * Created by Nano on 2015/10/20.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (n > m) {
            ListNode n1 = head, n2 = head.next, prev = null;
            int len = 2;
            while (len <= n) {
                //进行指针反转
                if (len > m) {
                    ListNode nextN2 = n2.next;
                    n2.next = n1;
                    n1 = n2;
                    n2 = nextN2;
                } else {
                    prev = n1;
                    n1 = n2;
                    n2 = n2.next;
                }
                len++;
            }
            //连接反转部分的头部和尾部
            //n1指向尾节点，n2指向尾部的next节点，prev指向反转部分的前一个节点
            if (prev == null) {
                //从head节点就开始反转的情况
                head.next = n2;
                head = n1;
            } else {
                prev.next.next = n2;
                prev.next = n1;
            }
        }
        return head;
    }
}
