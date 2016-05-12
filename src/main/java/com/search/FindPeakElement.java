package com.search;

/**
 * Created by lee on 16/2/17.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums){
        int n=nums.length;
        if(n==1){
            return 0;
        }
        for(int i=1;i<n-1;i++){
            if(nums[i-1]<nums[i]&&nums[i]>nums[i+1]){
                return i;
            }
        }

        if(nums[0]>nums[1]){
            return 0;
        }

        if(nums[n-1]>nums[n-2]){
            return n-1;
        }
        return 0;
    }

    public int findMin(int[] nums){
        int start=0;
        int end=nums.length-1;
        int mid=0;
        while(start<end){
            if(nums[start]<nums[end]){
                return nums[start];
            }
            if(end-start==1){
                return nums[end];
            }
            mid=(start+end)/2;
            if(nums[mid]>nums[start]){
                start=mid;
            }else {
                end=mid;
            }
        }
        return nums[0];
    }
}
