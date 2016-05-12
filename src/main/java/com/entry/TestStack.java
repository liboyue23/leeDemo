package com.entry;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.Stack;

/**
 * Created by lee on 16/2/10.
 */
public class TestStack {
    final int max = 1 << 20;

    @Test
    public void testFunction() {
        Stack<Integer> stack1 = new Stack<Integer>();
        MiniStack<Integer> stack2 = new MiniStack<Integer>();
        Random random = new Random();
        int value;
        for (int i = 0; i < max; i++) {
            value = random.nextInt(max);
            if (value % 3 != 0) {
                stack1.push(value);
                stack2.push(value);
            } else if (!stack1.isEmpty() && stack2.isEmpty()) {
                Assert.assertTrue(stack1.size() == stack2.size());
                Assert.assertTrue(stack1.peek().equals(stack2.peek()));
            }
        }

        while (!stack1.isEmpty()) {
            Assert.assertTrue(stack1.pop().equals(stack2.pop()));
        }
    }

}
