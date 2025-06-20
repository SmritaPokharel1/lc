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

        transfer(stack,buffer);

        return buffer.empty()? 0 : buffer.pop();

    }

    public void transfer(Stack<Integer> s1, Stack<Integer> s2){

        if(s2.isEmpty()){

            while(!s1.isEmpty()){

                s2.push(s1.pop());
            }
        }
    }

    public int peek() {

        transfer(stack,buffer);

        return buffer.isEmpty() ? 0 : buffer.peek();
    }

    public boolean empty() {

        return stack.isEmpty() && buffer.isEmpty();
    }
}
