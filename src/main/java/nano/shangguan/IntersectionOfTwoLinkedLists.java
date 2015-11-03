package nano.shangguan;

import util.LinkedListFactory;
import util.ListNode;

/**
 * Created by Nano on 2015/10/21.
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != nodeB) {
            if (nodeA != null && nodeB != null) {
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            } else if (nodeA == null) nodeA = headB;
            else nodeB = headA;
        }
        return nodeA;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        ListNode headB = new ListNode(6);
        headB.next = new ListNode(7);
        headB.next.next = new ListNode(8);
        ListNode common = LinkedListFactory.getListFromIntArray(new int[]{3, 4, 5});
        headA.next.next = common;
        headB.next.next.next = common;
        System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(headA, common));
    }
}
