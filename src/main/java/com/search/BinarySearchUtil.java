package com.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by lee on 16/2/17.
 */
public class BinarySearchUtil<T> {
    private Comparator<T> comp;

    public int compare(T a, T b) {
        if (comp != null) {
            return comp.compare(a, b);
        } else {
            Comparable<T> c = (Comparable<T>) a;
            return c.compareTo(b);
        }
    }

    public BinarySearchUtil() {
    }


    public int binarySearch(T[] array, int start, int end, T key) {
        end--;
        return recursion(array, start, end, key);
    }

    private int recursion(T[] array, int start, int end, T key) {
        if (start > end) {
            return -(start + 1);
        } else {
            int mid = (start + end) / 2;
            if (compare(key, array[mid]) == 0) {
                return mid;
            } else if (compare(key, array[mid]) < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            return recursion(array, start, end, key);
        }
    }

    @Test
    public void testBinarySearch(){
//        Integer[] array={1,3,5,6,7,8,10,13,16};
//        BinarySearchUtil<Integer> binarySearchUtil=new BinarySearchUtil<Integer>();
//        System.out.println(binarySearchUtil.binarySearch(array,0,array.length,16));
    }

}

class TestValid{
    public static final int MAX=1<<20;

    @Test
    public void test(){
        Integer[] array=new Integer[MAX];
        Random random=new Random();
        for(int i=0;i<MAX;i++){
            array[i]=random.nextInt();
        }
        Arrays.sort(array);

        BinarySearchUtil<Integer> binarySearchUtil=new BinarySearchUtil<Integer>();
        for(int i=0;i<MAX;i++){
            int key=random.nextInt(MAX);
            int start=random.nextInt(MAX);
            int end=random.nextInt(MAX);
            if(start<=end){
                int index1=binarySearchUtil.binarySearch(array,start,end,key);
                int index2=Arrays.binarySearch(array,start,end,key);
                Assert.assertTrue(index1==index2);
            }
        }
    }
}
