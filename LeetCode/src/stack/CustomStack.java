package stack;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/min-stack/description/
 */
public class CustomStack {

    private int[] stack;
    private int index;

    public CustomStack(int maxSize) {

        stack = new int[maxSize];
        Arrays.fill(stack, -1);
        index = -1;
    }

    public void push(int x) {


        if(index >= stack.length-1 ) return;

        index ++;

        stack[index] = x;

    }

    public int pop() {

        if(index >= stack.length || index < 0) return -1;

        int element = stack[index];

        index --;

        return element;
    }

    public void increment(int k, int val) {

        if(k > stack.length) k = stack.length;

        if(k < 0) return;

        int counter = 0;

        do{
            if(stack[counter] != -1){
                stack[counter] += val;
            }

            counter ++;

        }while(counter < k);

    }
}
