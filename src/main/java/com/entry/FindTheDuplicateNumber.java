package com.entry;

import java.util.HashSet;

/**
 * Created by lee on 16/2/15.
 */
public class FindTheDuplicateNumber {
    public int bruteForce(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] == nums[j]) {
                        return nums[i];
                    }
                }
            }
            return 0;
        }
    }

    public int hashFunction(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            HashSet<Integer> hashSet = new HashSet<Integer>();
            for (int i : nums) {
                if (!hashSet.contains(i)) {
                    hashSet.add(i);
                } else {
                    return i;
                }
            }
            return 0;
        }
    }
}
