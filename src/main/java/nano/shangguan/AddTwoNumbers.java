package nano.shangguan;

import util.ListNode;

/**
 * Created by Nano on 2015/10/22.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //在l1基础上修改
        ListNode n1 = l1, n2 = l2, prev = null;
        //记录低位向高位进的数字
        int toHigh = 0;
        while (n1 != null) {
            if (n2 == null) break;
            int value = n1.val + n2.val + toHigh;
            toHigh = value / 10;
            value = value % 10;
            n1.val = value;
            prev = n1;
            n1 = n1.next;
            n2 = n2.next;
        }
        //l1和l2长度相等，但高位需要进
        if (n1 == null && n2 == null && toHigh != 0) {
            prev.next = new ListNode(toHigh);
        } else {
            //l1和l2长度不等，多出来的部分继续和toHigh做加运算
            if (n2 != null) prev.next = n2;
            else n2 = n1;
            if (toHigh != 0) {
                while (n2 != null) {
                    int value = n2.val + toHigh;
                    toHigh = value / 10;
                    value = value % 10;
                    n2.val = value;
                    prev = n2;
                    n2 = n2.next;
                }
                //处理高位+1的情况
                if (toHigh != 0) prev.next = new ListNode(toHigh);
            }
        }
        return l1;
    }
}
