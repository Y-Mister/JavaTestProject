package com.algorithm.test1;

/**
 * Author:yuanhang
 * Date:2019-08-30 11:38
 * Description: 回文数判断，不转换为字符串形式，简单题
 * time:12ms  space:37.6MB
 * 数学方法的通过取模运算实现入栈出栈
 */
public class No9 {

    public static void main(String[] args) {
        boolean flag = isPalindrome(12321);
        System.out.println(flag==true?"yes":"NO");
    }

    public static boolean isPalindrome(int x) {

        if (x<0)
            return false;
        int ans=0,pop,temp=x;
        while (x>0){
            pop = x%10;
            ans = ans*10+pop;
            x=x/10;
        }
        if (ans==temp){
            return true;
        }

        return false;
    }

}
