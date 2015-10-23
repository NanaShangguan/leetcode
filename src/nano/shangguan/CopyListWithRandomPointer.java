package nano.shangguan;

import util.RandomListNode;

import java.util.HashMap;

/**
 * Created by Nano on 2015/10/23.
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head != null) {
            HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
            //复制结点
            RandomListNode node = head, copy = null, copyLast = null;
            while (node != null) {
                RandomListNode copyOfNode = new RandomListNode(node.label);
                if (copy == null) {
                    copy = copyOfNode;
                    copyLast = copy;
                }
                else {
                    copyLast.next = copyOfNode;
                    copyLast = copyLast.next;
                }
                map.put(node, copyOfNode);
                node = node.next;
            }
            //处理random link
            node = head;
            copyLast = copy;
            while (node != null) {
                RandomListNode random = node.random;
                if (random != null) {
                    RandomListNode copyOfRandom = map.get(node.random);
                    copyLast.random = copyOfRandom;
                }
                node = node.next;
                copyLast = copyLast.next;
            }
            return copy;
        }
        return null;
    }
}
