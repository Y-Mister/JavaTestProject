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
        int [] a = {3};
        int[] b ={1,4};
        double result = findMedianSortedArrays4(a, b);
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

    /*O(m+n)解法*/
    public static double findMedianSortedArrays2(int[] nums1,int[] nums2){
        int n = nums1.length;
        int m = nums2.length;
        int times = (n+m)/2+1; //奇数个、偶数个均需要遍历整个数组（len/2）+1次
        int left=-1,right=-1;  //用于保存两个遍历到的值
        int aStart=0,bStart=0;
        for (int i=0;i<times;i++){
            left=right;  //没向前遍历一次，都记住其后一个数，因为偶数个数的中位数是(left+right)/2
            if (aStart<n&&(bStart>=m||nums1[aStart]<nums2[bStart])){  //如果nums1数组未遍历完且nums2数组已遍历完或者当前nums1数组值大于nums2数组值
                right = nums1[aStart++];
            }else{
                right = nums2[bStart++];
            }
        }

        if ((n+m)%2==0){
            return (float)(left+right)/2.0;
        }else{
            return right;
        }


    }


    /*O(log(n+m))复杂度算法  log时间复杂度首先考虑二分法,求中位数，就是求第K小数的一种特殊情况，参考他人想法*/
    public static double findMedianSortedArrays3(int[] nums1,int[] nums2){

        int m = nums1.length;
        int n = nums2.length;
        int left = (n+m+1)/2;  //中位数左边数
        int right = (n+m+2)/2;  //中位数右边数，如果是一奇一偶，right和left相同，否则则是一左一右两个数用来计算中位数
        return (getKth(nums1,0,m-1,nums2,0,n-1,left)+getKth(nums1,0,m-1,nums2,0,n-1,right))*0.5;
    }

    public static double getKth(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
        int len1 = end1-start1+1;
        int len2 = end2-start2+1;

        if (len1>len2)
            return getKth(nums2,start2,end2,nums1,start1,end1,k);  //此处为了保证长度较小的始终位于第二个数组参数，避免多种情况的发生
        if (len1==0)
            return nums2[start2+k-1];

        //这里计算两个数组的其实位置，but why
        int i = start1+Math.min(len1,k/2)-1;  //此处出现下标溢出情形
        int j = start2+Math.min(len2,k/2)-1;

        if (nums1[i]>nums2[j]){
            return getKth(nums1,start1,end1,nums2,j+1,end2,k-(j-start2+1));
        }else{
            return getKth(nums1,i+1,end1,nums2,start2,end2,k-(i-start1+1));
        }

    }



    public static double findMedianSortedArrays4(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }


    /*存在数组下标溢出问题*/
    private static int getKth2(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth2(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth2(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth2(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

}
