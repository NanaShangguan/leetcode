package nano.shangguan;

import util.TreeLinkNode;

/**
 * Created by Nano on 2015/9/28.
 * 空间复杂度为O(1)
 * 由上到下修正node的next指针
 * 在根据已经修正过的上一行对下一行进行修正时，
 * 需要一个nextLevel指针来标记该行的头，以便开始下一次循环，
 * prev指针作为辅助，指向当前非空节点的上一个兄弟节点，进行连接操作
 * cursor指针为游标指针，在当前行向前游走，prev永远指向它的上一个非空节点
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode nextLevel = null;
            TreeLinkNode prev = null;
            while (root != null) {
                TreeLinkNode cursor = root.left;
                int i = 0;
                while (i < 2) {
                    i++;
                    if (cursor != null) {
                        if (nextLevel == null) nextLevel = cursor;
                        if (prev == null)
                            prev = cursor;
                        else {
                            prev.next = cursor;
                            prev = cursor;
                        }
                    }
                    cursor = root.right;
                }
                root = root.next;
            }
            root = nextLevel;
        }
    }
}
