package nano.shangguan;

import util.LinkedListFactory;
import util.ListNode;

/**
 * Created by Nano on 2015/10/22.
 * 其他方法：
 * 1. 合并成一个大链表，再进行优化排序
 * 2. 把本解法中的快速排序替换成堆排序
 * 3. 胜者树or败者树or堆
 * 刚开始有想过两两合并，但是顺序合并超时，有人的解法
 * 是分治法，直到剩下两组list，会比顺序合并快？
 */
public class MergeSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        //去掉空链表
        int len = lists.length;
        for (int i = 0; i < len; i++) {
            if (lists[i] == null) {
                //从末尾拿一个非空的补上
                while (len > i && lists[len - 1] == null) len--;
                if (len != i) {
                    lists[i] = lists[len - 1];
                    len--;
                } else len = i;
            }
        }
        //快速排序
        quickSort(lists, 0, len - 1);
        //设置base，表示list从哪个index开始元素不为null
        //**避免了新元素为null时的整体移位
        int base = 0;
        //合并之后的链表头指针和尾指针
        ListNode merged = null, last = null;
        while (base < len) {
            //更新合并之后的链表
            if (merged == null) {
                merged = lists[base];
                last = lists[base];
            } else {
                last.next = lists[base];
                last = last.next;
            }
            //更新待合并链表数组
            lists[base] = lists[base].next;
            if (lists[base] != null) {
                int pos = binarySearch(lists, base + 1, len - 1, lists[base].val);
                //pos值为-1说明0的位置不需要移动
                if (pos != -1) {
                    //[1, pos]的所有元素向前移动1位
                    ListNode node = lists[base];
                    moveForward(lists, base + 1, pos);
                    lists[pos] = node;
                }
            } else {
                //如果第一个为null，则base加一
                base++;
            }
        }
        return merged;
    }

    /**
     * lists中的[start, end]元素向前移动1位
     * @param lists
     * @param start
     * @param end
     */
    public void moveForward(ListNode[] lists, int start, int end) {
        for (int i = start; i <= end; i++) {
            lists[i - 1] = lists[i];
        }
    }

    /**
     * 返回target在lists中应该存在的位置下标
     * @param lists
     * @param start
     * @param end
     * @param target
     * @return
     */
    public int binarySearch(ListNode[] lists, int start, int end, int target) {
        int low = start, high = end;
        while (low <= high) {
            int middle = (low + high) / 2;
            int value = lists[middle].val;
            if (value == target) return middle;
            else if (value < target) low = middle + 1;
            else high = middle - 1;
        }
        return high;
    }

    /**
     * 快速排序
     * @param lists
     * @param start
     * @param end
     */
    public void quickSort(ListNode[] lists, int start, int end) {
        int low = start, high = end;
        if (low >= high) return;
        ListNode pivot = lists[low];
        //true时从高位开始扫描
        boolean flag = true;
        while (low < high) {
            if (flag) {
                if (lists[high].val < pivot.val) {
                    flag = false;
                    lists[low++] = lists[high];
                } else high--;
            } else {
                if (lists[low].val > pivot.val) {
                    flag = true;
                    lists[high--] = lists[low];
                } else low++;
            }
        }
        lists[low] = pivot;
        quickSort(lists, start, low - 1);
        quickSort(lists, low + 1, end);
    }

    public static void main(String[] args) {
        //初始化
        int[][] arr = {
//                {1, 4, 7, 9}, {4}, {3, 11, 12}, {2}, {5, 21, 47}, {6, 39}, {}
                {}, {-1,5,11}, {}, {6,10}
//                {}
        };
        ListNode[] lists = new ListNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            lists[i] = LinkedListFactory.getListFromIntArray(arr[i]);
        }
        //测试
        ListNode merged = new MergeSortedLists().mergeKLists(lists);

        //打印
        System.out.println(merged);
    }
}
