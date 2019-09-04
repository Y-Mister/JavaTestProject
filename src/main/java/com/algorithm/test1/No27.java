package com.algorithm.test1;

/**
 * Author:yuanhang
 * Date:2019-09-04 17:24
 * Description:leetcode 题27
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4
 * 注意这五个元素可为任意顺序
 */
public class No27 {

    public static void main(String[] args) {
        int[] nums = {};
        int len = removeElement(nums,3);
        System.out.println("数组长度"+len);
        for (int i=0;i<len;i++){
            System.out.println(nums[i]);
        }

    }

    /*错误答案，无法判断只有一个元素或者空数组情况*/
    public static int removeElement(int[] nums, int val) {

        int valIndex=0,temp,len=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==val){
                valIndex = i;
                for (int j=valIndex+1;j<nums.length;j++){
                    if (nums[j]!=val){
                        len = valIndex;
                        temp = nums[j];
                        nums[j] = nums[valIndex];
                        nums[valIndex] = temp;
                        break;
                    }

                }

            }

        }

        return len+1;
    }


    /*官方答案*/
    public static int removeElement2(int[] nums, int val){
        int valindex = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=val){
                nums[valindex++] = nums[i];
            }
        }
        return valindex;

    }




}
