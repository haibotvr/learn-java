package com.simon.learn;

import java.util.Stack;

/**
 * @author simon.wei
 */
public class StackSimulateQueue {

    private Stack<Integer> stack1;

    private Stack<Integer> stack2;

    public StackSimulateQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public int peek() {
        if(isEmpty()) {
            return -1;
        }
        if(stack2.isEmpty()) {
            stackToStack();
        }
        return stack2.peek();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(isEmpty()) {
            return -1;
        }
        if(stack2.isEmpty()) {
            stackToStack();
        }
        return stack2.pop();
    }

    private void stackToStack() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    private boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        StackSimulateQueue queue = new StackSimulateQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        int pop1 = queue.pop();
        int pop2 = queue.pop();
        int peek = queue.peek();
        System.out.println(pop1 + "....." + pop2 + "....." + peek);
    }
}
