package com.algorithm.test1;

/**
 * Author:yuanhang
 * Date:2019-09-05 10:21
 * Description:impements strstr()  aka indexOf() in java
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * 1ms   37.5
 */

public class No28 {

    public static void main(String[] args) {

        String haystack = "a";
        String needle = "a";
        int index = strStr(haystack,needle);
        System.out.println(index);

    }

    public static int strStr(String haystack, String needle) {

        int len1 = haystack.length();
        int len2 = needle.length();
        if (len2==0){
            return 0;
        }
        for (int i=0;len1-i>=len2;i++){
            if (needle.equals(haystack.substring(i,i+len2))){
                return i;
            }
        }
        return -1;
    }

}
