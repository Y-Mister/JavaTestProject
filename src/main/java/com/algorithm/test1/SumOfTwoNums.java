package com.algorithm.test1;

/**
 * Author:袁航
 * Date:2019-08-15 18:33
 * Description:1.两数字之和  leetCode判时53ms,空间38MB
 */
public class SumOfTwoNums {

    public static void main(String[] args) {

        int[] arr = {3,2,4};
        int target = 6;

        int[] res = twoSum(arr,target);
        for (int temp:res){
            System.out.println(temp);
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        boolean flag = false;
        //Arrays.sort(temp);

        for (int i=0;i<nums.length-1;i++){
            if (!flag) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        flag=true;
                        break;
                    }
                }
            }
        }

        return result;
    }

}
