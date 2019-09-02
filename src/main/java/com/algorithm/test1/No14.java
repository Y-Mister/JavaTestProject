package com.algorithm.test1;

/**
 * Created by yuanhang on 2019/9/2.
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 3ms   37.3MB
 */
public class No14 {


    public static void main(String[] args) {
        String[] strs = {"flow","fl","flight"};
        //String[] strs = {"dog","racer","cat"};
        //String[] strs={};
        String str = longestCommonPrefix(strs);
        System.out.println(str);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0)
            return "";
        int end=0;
        boolean flag=true;
        while (end<strs[0].length()){
            char cr = strs[0].charAt(end);
            for (int i=1;i<strs.length&&flag;i++){
                if (cr=='\0'){
                    flag=false;
                    break;
                }


                if (end>=strs[i].length()||cr != strs[i].charAt(end)){
                    flag=false;
                }
                /*if (flag==false)
                    break;*/
            }

            if (flag==false){
                break;
            }
            end++;

        }

        if (end>0){
            return strs[0].substring(0,end);
        }else {
            return "";
        }


    }



}
