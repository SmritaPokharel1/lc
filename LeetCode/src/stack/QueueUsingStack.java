package stack;

import java.util.Stack;

public class QueueUsingStack {

    private Stack<Integer> stack;
    private Stack<Integer> buffer;

    public QueueUsingStack() {

        stack = new Stack<>();
        buffer = new Stack<>();
    }

    public void push(int x) {

        stack.push(x);
    }

    public int pop() {

        if(stack.isEmpty()) return 0;

        transfer(stack,buffer);

        int result = buffer.pop();

        transfer(buffer, stack);

        return result;
    }

    public void transfer(Stack<Integer> s1, Stack<Integer> s2){

        if(s2.isEmpty()) {

                while (!s1.isEmpty()) {

                    s2.push(s1.pop());
                }
        }
    }

    public int peek() {

        transfer(stack,buffer);

        int result = buffer.peek();

        transfer(buffer,stack);

        return result;
    }

    public boolean empty() {

        return stack.isEmpty();
    }
}
