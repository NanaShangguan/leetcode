package nano.shangguan;

import java.util.Stack;

/**
 * Created by Nano on 2015/10/29.
 * 这个题好蠢
 * 需要用到两个栈
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer[]> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer[]>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x < minStack.peek()[0]) {
            minStack.push(new Integer[]{x, stack.size()});
        }
    }

    public void pop() {
        if (minStack.peek()[1] == stack.size()) minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek()[0];
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(-3);
        stack.push(4);

        stack.push(-10);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
