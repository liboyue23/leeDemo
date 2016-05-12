package com.entry;

import org.junit.Test;

/**
 * Created by lee on 16/2/13.
 * 回文字符串
 */
public class PalindromeString {
    public boolean isPalindrome(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !isAlpha(s.charAt(i))) {
                i++;
            }
            while (i < j && !isAlpha(s.charAt(j))) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isAlpha(char c) {
        if ((c >= '0' && c <= '9' || (c >= 'a' && c <= 'z'))) {
            return true;
        }
        return false;
    }

    @Test
    public void test(){
        StringBuffer stringBuffer=new StringBuffer("234234");
        stringBuffer.append("444");
    }
}
