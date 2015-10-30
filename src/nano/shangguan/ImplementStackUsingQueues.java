package nano.shangguan;

import java.util.LinkedList;

/**
 * Created by Nano on 2015/10/30.
 */
public class ImplementStackUsingQueues {
    private LinkedList<Integer> q1;
    private LinkedList<Integer> q2;

    public ImplementStackUsingQueues() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int len = q1.size();
        for (int i = len; i > 0; i--) {
            if (i == 1) q1.pop();
            else q2.add(q1.pop());
        }
        LinkedList<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Get the top element.
    public int top() {
        int len = q1.size();
        int top = 0;
        for (int i = len; i > 0; i--) {
            top = q1.pop();
            q2.add(top);
        }
        LinkedList<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}
