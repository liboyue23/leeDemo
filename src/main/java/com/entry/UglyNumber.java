package com.entry;

/**
 * Created by lee on 16/2/12.
 */
public class UglyNumber {
    public boolean isUgly(int num){
        int n=num;
        if(n<=0){
            return false;
        }
        if(n==1){
            return true;
        }
        while(n%2==0){
            n/=2;
        }
        while (n%3==0){
            n/=3;
        }
        while(n%5==0){
            n/=5;
        }
        if(n==1){
            return true;
        }else {
            return false;
        }
    }

    public int nthUglyNumber(int n){
        int count =1;
        int i=1;
        while (true){
            if(isUgly(i)){
                if(count==n){
                    return i;
                }
                count++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println(60%24);
    }
}
