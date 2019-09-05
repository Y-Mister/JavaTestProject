package com.algorithm.test1;

/**
 * Author:yuanhang
 * Date:2019-09-05 11:10
 * Description:
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * You may assume no duplicates in the array.
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 */
public class No35 {

    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        int target=2;

        int result = searchInsert2(nums,target);
        System.out.println(result);
    }

    /*属于暴暴力，O(n)时间复杂度*/
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length,i;
        for (i=0;i<len;){
            if (nums[i]<target){
                i++;
            }else{
                break;
            }
        }

        return i;
    }

    /*二分查找法，此处算法有问题*/
    public static int searchInsert2(int[] nums, int target){
        int len=nums.length;
        int left=0,right=len-1,mid=0;
        while (left<right){
            mid=(left+right)>>>1;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]<target){
                left=mid+1;
            }else{
                right = mid-1;
            }
        }

        /*此处如果出了循环，需要对最后一个数进行比较，如果不比较将无法正确输出应该在的位置*/
        if(nums[left]<target){
            return ++left;
        }else{
            return  left;
        }

    }

    /**
     * 二分的基本思想："排除法"，每一轮通过循环排除一半的元素，使用O(logn)时间复杂度将区间缩小至一个数，最终进行后处理判断返回（后处理并不一定需要）leetCode No35官方题解
     * 1.定界，找到问题中已知或隐含的左右边界，例如本题中的 left=0，right=数组长度-1,需要注意的是，当边界与数组下标相关时，
     *      需要考虑是否越界的问题
     * 2.二分循环的基本条件，采用 while（left< right）而不是 while（left <= right），如果写成 while（left <= right），退出循环后
     *      需要考虑返回 left 还是 right，因为其退出条件为 left>right，这在不同的具体问题下返回值极易出错；
     *      而采用 while（left< right），退出循环条件必存在一个 left=right （二分的特性），此时返回left与right是相同的，注意
     *      此时还存在一个索引为 left（right）的值未进行比较，有必要比较时可在退出循环时比较即可
     * 3.中位数的确定，采用 mid = （left+right）>>> 1 的方式而非 mid = (left+right)/2 或者 mid=left+（right-left）/2，因为后两种
     *      写法在 left/right 极大的情况下会溢出
     * 4.伪代码：
     *      left，right
     *      while（left< right）{
     *          mid = (left+right)>>>1;
     *          if( 排除中位数的逻辑){   此处的下方代码的逻辑依据实际问题可以进行修改优化
     *              left = mid+1; / right = mid-1;
     *          }else{
     *              right=mid;   / left = mid;   此处边界不收缩，当候选区只剩两个元素，可能出现中位数始终选中该边界，可能导致死循环
     *          }
     *      }
     *
     * 5.关于 mid=(left+right)>>>1,解释为当 left+right 整型溢出后将变成负数，此时除以2将得到一个负数中值，但是经过无符号右移（即 >>>）
     *      可以得到在不溢出的情况下的正确结果
     *      >> :右移，丢弃右边指定位数，左边补上符号位
     *      >>> : 无符号右移，丢弃右边指定位数，左边补上0，对于正数，其与 >> 相同，但对于负数运算后将变成正数
     *
     */

}
