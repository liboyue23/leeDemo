package com.entry;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by lee on 16/2/8.
 */
public class PushAndPop {
    public boolean checkValid(Integer[] pushSequence,Integer[] popSequence){
        Stack<Integer> stack=new Stack<Integer>();
        int i=0;
        for(Integer k :popSequence){
            if(!stack.isEmpty()&&stack.peek().equals(k)){
                stack.pop();
            }else {
                while(true){
                    if(i>=pushSequence.length){
                        return false;
                    }
                    if(pushSequence[i].equals(k)){
                        i++;
                        break;
                    }else {
                        stack.push(pushSequence[i]);
                        i++;
                    }
                }
            }
        }
        return true;
    }

    @Test
    public void test(){
        Integer[] push={1,2,3,4,5};
        Integer[] pop1={4,5,3,2,1};
        Integer[] pop2={4,3,5,1,2};
        Integer[] pop3={3,5,4,2,1};
        boolean flag1=checkValid(push,pop1);
        boolean flag2=checkValid(push,pop2);
        boolean flag3=checkValid(push,pop3);
        System.out.println(flag1+"  "+flag2+"  "+flag3);
    }
}
