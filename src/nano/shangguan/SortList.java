package nano.shangguan;

import util.ListNode;

/**
 * Created by Nano on 2015/10/16.
 */
public class SortList {

    public ListNode sortList(ListNode head) {

    }

    private ListNode mergeSort(ListNode head) {
        if (head == null) return null;
        //快慢指针找出中点
        ListNode fast = head, slow = head;
        int len = 0;
        while (fast != null) {
            len++;
            if (len != 1 && len % 2 == 1) slow = slow.next;
            fast = fast.next;
        }
        ListNode l1 = head, l2 = slow.next;
        slow.next = null;
        l1 = mergeSort(l1);
        l2 = mergeSort(l2);
        return mergeTwoSortedLists(l1, l2);
    }

    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode p = l1, prevP = null, q = l2;
        while (p != null && q != null) {
            if (p.val < q.val) {
                prevP = p;
                p = p.next;
            } else {
                ListNode nextQ = q.next;
                q.next = p;
                if (prevP != null) prevP.next = q;
                else l1 = q;
                prevP = q;
                q = nextQ;
            }
        }
        //把l2多余的补充到l1后面
        if (q != null) {
            if (prevP != null) prevP.next = q;
            else l1 = l2;
        }
        return l1;
    }

    /**
     * 快速排序，有用例超时
     * @param head
     * @return
     */
    private ListNode quickSort(ListNode head) {
        if (head == null) return null;
        //smaller有可能为null
        ListNode node = head.next, smaller = node, prev = null;
        head.next = null;
        ListNode lastBig = head;
        while (node != null) {
            //把值比pivot大的节点插入到链表head末尾
            if (node.val > head.val) {
                if (prev != null) prev.next = node.next;
                lastBig.next = node;
                lastBig = node;
                node = node.next;
                lastBig.next = null;
            } else {
                prev = node;
                node = node.next;
            }
        }
        ListNode sortedSmaller = quickSort(smaller);
        ListNode sortedBigger = quickSort(head.next);

        if (sortedSmaller == null) {
            head.next = sortedBigger;
            return head;
        } else {
            //找到较小值链表的末尾节点
            ListNode n = sortedSmaller;
            while (n.next != null) {
                n = n.next;
            }
            n.next = head;
            head.next = sortedBigger;
            return sortedSmaller;
        }
    }

    /**
     * 冒泡排序，超时
     * @param head
     * @return
     */
    private ListNode bubbleSort(ListNode head) {
        if (head != null) {
            ListNode last = null;
            while (last != head) {
                ListNode p = head, q = head.next, prev = null;
                boolean anyExchange = false;
                while (q != last) {
                    if (p.val > q.val) {
                        if (prev == null) head = q;
                        else prev.next = q;
                        p.next = q.next;
                        q.next = p;
                        prev = q;
                        q = p.next;
                        anyExchange = true;
                    } else {
                        prev = p;
                        p = q;
                        q = q.next;
                    }
                }
                if (!anyExchange) break;
                last = p;
            }
        }
        return head;
    }
}
