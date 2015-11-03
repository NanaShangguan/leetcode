package nano.shangguan;

import util.LinkedListFactory;
import util.ListNode;

/**
 * Created by Nano on 2015/10/22.
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head != null) {
            ListNode sorted = head;
            //初始循环
            head = head.next;
            sorted.next = null;
            while (head != null) {
                //在sorted中顺序找到head的位置
                ListNode nextHead = head.next;
                ListNode node = sorted;
                if (node.val < head.val) {
                    while (node.next != null) {
                        if (node.next.val > head.val) break;
                        node = node.next;
                    }
                    head.next = node.next;
                    node.next = head;

                } else {
                    head.next = sorted;
                    sorted = head;
                }
                head = nextHead;
            }
            head = sorted;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new InsertionSortList().insertionSortList(
                LinkedListFactory.getListFromIntArray(new int[]{3, 2, 4})
        ));
    }
}
