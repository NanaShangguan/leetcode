package nano.shangguan;

import java.util.Stack;

/**
 * Created by Nano on 2015/10/30.
 */
public class MyQueue {
    private Stack<Integer> stack, helper;

    public MyQueue() {
        stack = new Stack<Integer>();
        helper = new Stack<Integer>();
    }
    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        checkHelper();
        helper.pop();
    }

    // Get the front element.
    public int peek() {
        checkHelper();
        return helper.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty() && helper.isEmpty();
    }

    private void checkHelper() {
        if (helper.isEmpty()) {
            while (!stack.isEmpty())
                helper.push(stack.pop());
        }
    }
}
