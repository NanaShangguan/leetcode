package nano.shangguan;

import util.ListNode;

/**
 * Created by Nano on 2015/10/20.
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k > 1) {
            int len = lengthOfLinkedList(head);
            int multiple = len / k;
            //判断是否需要进行反转
            if (multiple > 0) {
                //multiple > 0 且 K > 1，每组至少有两个元素
                ListNode prev = null, n1 = head, n2 = head.next;
                int count = 1;
                int total = multiple * k;
                while (count <= total) {
                    count++;
                    //掉转相邻节点的指向
                    ListNode nextN2 = n2.next;
                    n2.next = n1;
                    n1 = n2;
                    n2 = nextN2;
                    //如果到了一组的最后一个节点
                    if (count % k == 0) {
                        if (prev == null) {
                            prev = head;
                            head.next = n2;
                            head = n1;
                        } else {
                            ListNode nextPrev = prev.next;
                            prev.next.next = n2;
                            prev.next = n1;
                            prev = nextPrev;
                        }
                        n1 = n2;
                        if (n2 != null) n2 = n2.next;
                        count++;
                    }
                }
            }
        }
        return head;
    }

    /**
     * 返回链表的长度
     * @param head 链表头指针
     * @return 链表长度 int
     */
    private int lengthOfLinkedList(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
