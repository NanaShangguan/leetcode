package util;

/**
 * Created by Nano on 2015/9/21.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        String str = val + "";
        ListNode node = this.next;
        while (node != null) {
            str += "->" + node.val;
            node = node.next;
        }
        return str;
    }
}
