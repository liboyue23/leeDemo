package com.entry;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lee on 16/2/12.
 */
public class TwoSum {
    public void printResult(int a, int b) {
        System.out.println("[" + a + "," + b + "]");
    }

    public void twoSum01(int[] array, int s) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] + array[j] == s) {
                    printResult(array[i], array[j]);
                    break;
                }
            }
        }
    }

    /**
     * 定义头指针和尾指针
     * @param array
     * @param s
     */
    public void twoSum02(int[] array, int s) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            int sum = array[i] + array[j];
            if (sum == s) {
                printResult(array[i], array[j]);
                i++;
                j--;
            } else if (sum < s) {
                i++;
            } else {
                j--;
            }
        }
    }

    public void twoSum03(int[] array, int s){
        int n=array.length;
        for(int i=0;i<n-1;i++){
            int another=s-array[i];
            if(Arrays.binarySearch(array,i+1,n-1,another)>=i+1){
                printResult(array[i],another);
            }
        }
    }

    @Test
    public void test() {
        int[] array = {1, 3, 4, 5, 8, 9, 11};
        int s = 13;
        twoSum01(array, s);
    }

    @Test
    public void test02(){
        int[] array = {1, 3, 4, 5, 8, 9, 11};
        int s = 13;
        twoSum02(array,s);
    }
}
