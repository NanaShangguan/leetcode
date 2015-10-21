package nano.shangguan;

import util.LinkedListFactory;
import util.ListNode;

/**
 * Created by Nano on 2015/10/20.
 * Partition List
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head != null) {
            ListNode node = head
                    , smallerHead = null, smallerTail = null
                    , biggerHead = null, biggerTail = null, prev = null;
            boolean flag = true;
            //head元素的值决定先开始找哪种元素
            if (head.val >= x) flag = false;

            while (node != null) {
                if (flag && node.val >= x) {
                    if (smallerHead ==  null) smallerHead = head;
                    else smallerTail.next = head;
                    smallerTail = prev;
                    smallerTail.next = null;
                    head = node;
                    flag = false;
                } else if (!flag && node.val < x) {
                    if (biggerHead == null) biggerHead = head;
                    else biggerTail.next = head;
                    biggerTail = prev;
                    biggerTail.next = null;
                    head = node;
                    flag = true;
                } else {
                    prev = node;
                    node = node.next;
                }
            }

            //处理结尾的一段
            if (flag) {
                if (smallerHead == null) smallerHead = head;
                else smallerTail.next = head;
                smallerTail = prev;
            } else {
                if (biggerHead == null) biggerHead = head;
                else biggerTail.next = head;
            }
            //合并两段
            if (smallerHead != null) {
                smallerTail.next = biggerHead;
                head = smallerHead;
            } else head = biggerHead;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionList().partition(
                LinkedListFactory.getListFromIntArray(new int[]{}), 3
        ));
    }
}
