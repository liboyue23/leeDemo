package com.entry;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lee on 16/2/10.
 */
public class TestQueue {
    @Test
    public void testJDKQueue(){
        Queue<Integer> queue=new LinkedList<Integer>();
        System.out.println(queue.size());
        int[] arr={1,2,3,4,5};
        for(int k:arr){
            queue.offer(k);
        }
        while(!queue.isEmpty()){
            System.out.println(queue.peek()+"  "+queue.poll());
        }
    }
}
