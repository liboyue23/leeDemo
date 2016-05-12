package com.entry;

import org.junit.Test;

import java.util.Random;
import java.util.Stack;

/**
 * Created by lee on 16/2/10.
 */
public class TestSpeed {
    final int max=1<<23;

    @Test
    public void testStack() {
        Stack<Integer> stack1 = new Stack<Integer>();
        Random random = new Random();
        int value;
        for (int i = 0; i < max; i++) {
            value = random.nextInt(max);
            if (value % 3 != 0) {
                stack1.push(value);
            } else if (!stack1.isEmpty()) {
                stack1.peek();
                stack1.pop();
            }
        }

        while (!stack1.isEmpty()) {
            stack1.pop();
        }
    }

    @Test
    public void testMiniStack(){
        MiniStack<Integer> stack1 = new MiniStack<Integer>();
        Random random = new Random();
        int value;
        for (int i = 0; i < max; i++) {
            value = random.nextInt(max);
            if (value % 3 != 0) {
                stack1.push(value);
            } else if (!stack1.isEmpty()) {
                stack1.peek();
                stack1.pop();
            }
        }

        while (!stack1.isEmpty()) {
            stack1.pop();
        }
    }
}
