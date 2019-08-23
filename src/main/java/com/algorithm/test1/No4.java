package com.algorithm.test1;

import java.util.Arrays;

/**
 * Author:袁航
 * Date:2019-08-21 13:55
 * Description:
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * pass by first commit
 * result : time 8ms over 88.40%   space:5.9MB  over 76.66%  不满足O(log(n+m))的要求，惭愧，再战
 */
public class No4 {

    public static void main(String[] args) {
        int [] a = {1};
        int[] b ={3,4};
        double result = findMedianSortedArrays(a,b);
        System.out.println(result);
    }
    /*不满足复杂度要求*/
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length;
        nums1 = Arrays.copyOf(nums1,nums1.length+nums2.length);
        System.arraycopy(nums2,0,nums1,len, nums2.length);
        Arrays.sort(nums1);
        double midNum=0;
        if (nums1.length%2==0){
            int sit1 = nums1.length/2;
            midNum = (float)(nums1[sit1]+nums1[sit1-1])/2.0;

        }else{
            int sit2 = nums1.length/2;
            midNum = nums1[sit2];
        }
        return midNum;
    }


}
