package com.entry;

import java.util.Stack;

/**
 * Created by lee on 16/2/10.
 */
public class MyQueue {
    public Stack<Integer> stack1 = new Stack<Integer>();
    public Stack<Integer> stack2 = new Stack<Integer>();

    public int size;

    public void push(int x) {
        stack1.push(x);
        size++;
    }

    public void pop() {
        if (!stack2.isEmpty()) {
            stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack2.pop();
        }
        size--;
    }

    public void peek() {
        if (!stack2.isEmpty()) {
            stack2.peek();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack2.peek();
        }
    }

    public boolean empty() {
        return size == 0 ? true : false;
    }
}
