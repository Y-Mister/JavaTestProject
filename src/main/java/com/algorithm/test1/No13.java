package com.algorithm.test1;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:yuanhang
 * Date:2019-08-30 11:54
 * Description:罗马数字转整数，LeetCode 第十三题 简单题
 * time：21ms  space：43.7MB
 */
public class No13 {

    public static void main(String[] args) {
        int num = romanToInt("IXLVIII");
        System.out.println(num);
    }

    public static int romanToInt(String s) {
        int ans=0;
        int left,right;
        Map<String,Integer> romanNum = new HashMap<>();
        romanNum.put("I",1);
        romanNum.put("V",5);
        romanNum.put("X",10);
        romanNum.put("L",50);
        romanNum.put("C",100);
        romanNum.put("D",500);
        romanNum.put("M",1000);

        int len = s.length();
        boolean flag=false;
        left=romanNum.get(s.charAt(0)+"");
        for (int i=1;i<len;i++){
                right=romanNum.get(s.charAt(i)+"");
            if (left>=right){
                ans+=left;
                left=right;
            }else{
                ans-=left;
                left=right;
            }
        }
        ans+=left;

        return ans;
    }

}

