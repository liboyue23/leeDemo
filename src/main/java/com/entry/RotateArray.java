package com.entry;

/**
 * Created by lee on 16/2/12.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class RotateArray {
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

    public void reverse(int[] array, int start, int end) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = start, j = end; i < j; i++, j--) {
            swap(array, i, j);
        }
    }

    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        int n = nums.length;
        if (k > n) {
            k %= n;
        }
        reverse(nums, 0, n - 1 - k);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
}
