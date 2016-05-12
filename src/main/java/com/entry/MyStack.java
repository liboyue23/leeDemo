package com.entry;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lee on 16/2/12.
 */
public class MyStack {
    public Queue<Integer> queue1 = new LinkedList<Integer>();
    public Queue<Integer> queue2 = new LinkedList<Integer>();

    private int size;

    public void push(int x) {
        if (empty() || queue1.isEmpty()) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
        size++;
    }

    public void pop() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            queue1.poll();
        } else {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            queue2.poll();
        }
        size--;
    }

    public int top() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            int k = queue1.poll();
            queue2.offer(k);
            return k;
        } else {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            int k = queue2.poll();
            queue1.offer(k);
            return k;
        }
    }

    public boolean empty() {
        return size == 0;
    }
}
