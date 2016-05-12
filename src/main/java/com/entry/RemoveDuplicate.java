package com.entry;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 16/2/12.
 */
public class RemoveDuplicate {
    public int remove01(int[] nums){
        if(nums==null||nums.length==0){
            return 0;
        }else if(nums.length==1){
            return 1;
        }else {
            int end=nums.length-1;
            List<Integer> list=new ArrayList<Integer>();
            int p=0;
            int next=p+1;
            while(p<=end){
                if(p==end){
                    list.add(nums[p]);
                    p++;
                }else {
                    if(nums[p]!=nums[next]){
                        list.add(nums[p]);
                        p=next;
                    }else {
                        while (next<=end&&nums[p]==nums[next]){
                            next++;
                        }
                    }
                }
            }
            for(int i=0;i<list.size();i++){
                nums[i]=list.get(i);
            }
            return list.size();
        }
    }

    public void printNewArray(int[] array,int len){
        for(int i=0;i<len;i++){
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

    @Test
    public void test(){
        int[] nums={1,2,2,2,3,4,5,6,6,7,7,7,8};
        int len=remove01(nums);
        System.out.println(len);
        printNewArray(nums,len);
    }
}
