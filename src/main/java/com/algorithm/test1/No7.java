package com.algorithm.test1;

/**
 * Author:yuanhang
 * Date:2019-08-29 19:45
 * Description:leetcode 题6
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 输入: 123
 * 输出: 321
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 他人数学解法
 */
public class No7 {

    private static int MAX_VALUE=2147483647;
    private static int MIN_VALUE=-2147483648;

    public static void main(String[] args) {
        int result = reverse(521);
        System.out.println(result);
    }

    /**
     * 思路：与字符串翻转类似，每次从尾部取出个位数放到头部，用数学方法实现就是
     * ans = ans*10+pop   ans为结果，pop为每次从尾部取出的个位数
     * 关于溢出判断，首先已经固定了最大值
     * 忽略各位数，如果当前数已经大于最大值/10，则该数翻转必溢出
     * 若当前数等于最大值/10，则需要将当前取得的个位数与最大值个位数进行比较判断
     * 负数与正数判断逻辑一致
     */

    public static int reverse(int x){
        int ans=0;
        int pop=0;
        while (x!=0){
            pop = x%10;
            if (ans>MAX_VALUE/10||(ans==MAX_VALUE/10&&pop>7))
                return 0;
            if (ans<MIN_VALUE/10||(ans==MIN_VALUE/10&&pop<-8))
                return 0;

            ans=ans*10+pop;
            x=x/10;
        }

        return ans;
    }


}
