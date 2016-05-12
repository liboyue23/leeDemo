package com.entry;

import org.junit.Test;

/**
 * Created by lee on 16/2/12.
 * 最大公约数和最小公倍数
 */
public class GcdAndLcm {
    public int gcd01(int m,int n){
        int a=Math.max(m,n);
        int b=Math.min(m, n);
        m=a;
        n=b;
        int r;
        while(m%n!=0){
            r=m%n;
            m=n;
            n=r;
        }
        return n;
    }

    public int gcd02(int m,int n){
        int a=Math.max(m,n);
        int b=Math.min(m,n);
        if(a%b==0){
            return b;
        }else {
            return gcd02(b,a%b);
        }
    }

    @Test
    public void testGcd01(){
        System.out.println(gcd01(100,44));
        System.out.println(gcd01(44,100));
    }

    @Test
    public void testGcd02(){
        System.out.println(gcd02(100,44));
        System.out.println(gcd02(44,100));
    }
}
