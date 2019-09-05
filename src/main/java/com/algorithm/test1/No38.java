package com.algorithm.test1;

/**
 * Author:yuanhang
 * Date:2019-09-05 14:36
 * Description:leetCode No38
 * The count-and-say sequence is the sequence of integers with the first five terms as following
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * as I konw,1 is fixed,then the second is the count-and-say explain of the first one,the third is the count-and-say of the forth one
 *      and so on , so the sixed is:
 * 6.     312211
 * 7.     13111221
 *  analysis：for the last num string,we just need to count from last to first,how many the same consecutive number , we use the num
 *  of this num plus itself to form the next number string. from first to the end is also ok
 *
 *  programmer1 result: time 10 35.52 || space 36.3    72.24
 *  programmer2 result: time 9 43.93 || space 36.3    72.24
 *
 */
public class No38 {

    public static void main(String[] args) {

        System.out.println(countAndSay3(6));
    }
    /*倒序*/
    public static String countAndSay(int n) {
        String nowStr = "1";
        StringBuffer sbf = new StringBuffer();
        for (int i=1;i<n;i++){

            int len = nowStr.length()-1,count=0;
            char cr = ' ';
            for (int j=len;j>=0;){
                cr = nowStr.charAt(j);
                if (cr!=nowStr.charAt(len)){
                    sbf.append(nowStr.charAt(len)).append(count+"");
                    len=j;
                    count=0;
                }else{
                    count++;
                    j--;
                }

            }
            sbf.append(cr).append(count+"");
            nowStr = sbf.reverse().toString();
            count=0;
            sbf.delete(0,nowStr.length());

        }

        return nowStr;
    }

    /*倒序，优化stringBuffer清空*/
    public static String countAndSay2(int n) {
        String nowStr = "1";
        StringBuffer sbf = new StringBuffer();
        for (int i=1;i<n;i++){

            int len = nowStr.length()-1,count=0;
            char cr = ' ';
            for (int j=len;j>=0;){
                cr = nowStr.charAt(j);
                if (cr!=nowStr.charAt(len)){
                    sbf.append(nowStr.charAt(len)).append(count+"");
                    len=j;
                    count=0;
                }else{
                    count++;
                    j--;
                }

            }
            sbf.append(cr).append(count+"");
            nowStr = sbf.reverse().toString();
            count=0;
            sbf.setLength(0);  //时间优化
            //sbf.delete(0,nowStr.length());

        }

        return nowStr;
    }

    /*正序，去掉翻转的时间耗费，事实证明，leetcode的时间与空间耗费并不可信*/
    public static String countAndSay3(int n) {
        String nowStr = "1";
        StringBuffer sbf = new StringBuffer();
        for (int i=1;i<n;i++){

            int len = nowStr.length()-1,count=0;
            char cr = ' ';
            int first=0;
            for (int j=0;j<=len;){
                cr = nowStr.charAt(j);
                if (cr!=nowStr.charAt(first)){
                    sbf.append(count+"").append(nowStr.charAt(first));
                    first=j;
                    count=0;
                }else{
                    count++;
                    j++;
                }
            }
            sbf.append(count + "").append(cr);
            nowStr = sbf.toString();
            count=0;
            sbf.setLength(0);  //时间优化

        }

        return nowStr;
    }



}
