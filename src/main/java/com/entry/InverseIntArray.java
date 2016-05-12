package com.entry;

import org.junit.Test;

import java.util.List;

/**
 * Created by lee on 16/2/12.
 * 数组翻转
 */
public class InverseIntArray {
    public void swap(int[] array, int a, int b) {
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }

    public void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    public void inverse01(int[] array){
        if(array==null||array.length<=1){
            return;
        }
        for(int i=0,j=array.length-1;i<j;i++,j--){
            swap(array,i,j);
        }
    }

    @Test
    public void test01(){
        int[] array1={1,2,3,4,5,6,7};
        printArray(array1);
        inverse01(array1);
        printArray(array1);



        int[] array2={1,2,3,4,5,6};
        printArray(array2);
        inverse01(array2);
        printArray(array2);
    }

    public <T> void testprint(List<T> list){

    }
}
