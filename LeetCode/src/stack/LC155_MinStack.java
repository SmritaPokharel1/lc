package stack;

import java.util.Stack;

public class LC155_MinStack {

    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    public LC155_MinStack() {

        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {

        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) minStack.push(val);
    }

    public void pop() {

        int popped = 0;

        if (!stack.isEmpty()) popped = stack.pop();

        if (!minStack.isEmpty() && popped == minStack.peek()) minStack.pop();
    }

    public int top() {

        return !stack.isEmpty() ? stack.peek() : 0;
    }

    public int getMin() {

        return !minStack.isEmpty() ? minStack.peek() : 0;
    }
}
