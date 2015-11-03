package nano.shangguan;

import util.ListNode;

/**
 * Created by Nano on 2015/10/21.
 */
public class DeleteNodeInLinkedList {
    /**
     * 在未知要删除节点的前节点的情况下，采用复制值的方式删除节点值
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        new DeleteNodeInLinkedList().deleteNode(head.next);
        System.out.println(head);
    }
}
