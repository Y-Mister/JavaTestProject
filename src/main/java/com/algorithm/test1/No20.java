package com.algorithm.test1;

/**
 * Author:yuanhang
 * Date:2019-09-03 18:39
 * Description:<描述>
 * 1ms 99.99  34.8MB 82.54
 */
public class No20 {


    public static void main(String[] args) {
        String s="";
        System.out.println(isValid(s)==true?"yes":"no");

    }


    public static boolean isValid(String s) {

        int len=s.length();
        int top=0;
        char[] arr = new char[len+1];
        for (int i=0;i<len;i++){
            if (top>0&&((s.charAt(i)==')'&&arr[top-1]=='(')||(s.charAt(i)==']'&&arr[top-1]=='[')||(s.charAt(i)=='}'&&arr[top-1]=='{'))){
                top--;
                arr[top]='\0';
            }else{

                arr[top]=s.charAt(i);
                top++;
            }

        }

        if (top==0){
            return true;
        }

        return false;
    }


}
