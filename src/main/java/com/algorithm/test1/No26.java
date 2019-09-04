package com.algorithm.test1;

/**
 * Author:yuanhang
 * Date:2019-09-03 19:56
 * Description:
 * Description:给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *  给定数组 nums = [1,1,2],
 *  函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2
 *
 *  给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *  函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4
 *  思路：类滑动窗口解决
 *  2ms 91.49   44.7MB  70.92
 */
public class No26 {

    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        for (int temp:nums){
            System.out.println(temp);
        }
    }

    public static int removeDuplicates(int[] nums) {

        int start=0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]!=nums[start]){
                nums[++start]=nums[i];
            }
        }
        return start+1;
    }

}
