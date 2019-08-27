package com.algorithm.test1;

/**
 * Author:袁航
 * Date:2019-08-15 20:10
 * Description:<描述>
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


 结果：时间111ms 20.48   空间66.8MB 13.33 从首次提交到最终完成忽略的点：
 字符串为空、字符串只有一个元素，max值覆盖放置位置错误
 */
public class No3 {

         public static void main(String[] args) {
            String s = "bbbbbb";
            int len1 = lengthOfLongestSubstring2(s);
             int len2 = solution(s);
            System.out.println(len1+"   "+len2);
         }
        /*自己的弱鸡答案*/
         public static int lengthOfLongestSubstring(String s) {

          char[] array = s.toCharArray();
          int max = 1,count;
          int len = array.length;
          if (len==0)
           return 0;
          HashSet set = new HashSet();
          for (int i=0;i<len;i++){
            set.clear();
            set.add(array[i]);
            count=1;
            for (int j=i+1;j<len;){
               if (!set.contains(array[j])){
                  count++;
                  set.add(array[j]);
                  j++;
               }else{
                  if (max<count)
                    max=count;
                  break;
               }

             if (j==len&&max<count)
                max=count;
            }

          }

          return max;
         }

         /*他人优秀答案 滑动窗口法：即始终维持一个start-end的窗口，其长度未知，维持一个map，其存放探查到的key与其当前位置+1的value，这表示若end处碰到与key相同的值，则从该value向后将不再存在重复情况，每次探查后无论是否重复均要更新map的key-value值，start与end的位置，同时计算当前窗口的长度从而计算ans*/
         public static int lengthOfLongestSubstring2(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int end = 0, start = 0; end < n; end++) {
             char alpha = s.charAt(end);
             if (map.containsKey(alpha)) {
              start = Math.max(map.get(alpha), start);
             }
             ans = Math.max(ans, end - start + 1);
             map.put(s.charAt(end), end + 1);
            }
            return ans;
         }


        public static int solution(String s){

            int start=0,end=0,len=0;
            char[] array = s.toCharArray();
            Map<Character,Integer> map = new HashMap<>();

            for (;end<s.length();end++){
                if (!map.containsKey(array[end])){
                    map.put(array[end],end+1);
                }else{
                    start = map.get(array[end]); //start=Math.max(start,map.get(array[end]))
                    map.put(array[end],end+1);
                }
                len = Math.max(len,end-start+1);
            }

            return len;
        }


    }


