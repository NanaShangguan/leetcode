package nano.shangguan;

import util.ListNode;

/**
 * Created by Nano on 2015/10/16.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head != null) {
            ListNode quick = head, slow = head;
            int len = 0;
            while (quick != null) {
                len++;
                if (len != 1 && len % 2 == 1) slow = slow.next;
                quick = quick.next;
            }
            int arrayLength = len / 2;
            int[] half = new int[arrayLength];
            ListNode node = head;
            for (int i = 0; i < arrayLength; i++, node = node.next) {
                half[i] = node.val;
            }
            slow = slow.next;
            for (int i = arrayLength - 1; slow != null; i--, slow = slow.next) {
                if (half[i] != slow.val) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
        System.out.println(new PalindromeLinkedList().isPalindrome(head));
    }
}
