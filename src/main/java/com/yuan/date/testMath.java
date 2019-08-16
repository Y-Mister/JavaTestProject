package com.yuan.date;

/**
 * Author:helloboy
 * Date:2019-07-21 15:09
 * Description:<描述>
 */
public class testMath {
    public static void main(String[] args) {
        System.out.println(Math.ceil(3.2));//上取整
        System.out.println(Math.floor(3.8));//下取整
        System.out.println(Math.round(3.2));//四舍五入
        System.out.println(Math.round(3.8));//四舍五入
        //绝对值、开方、a的b次幂等操作
        System.out.println(Math.abs(-45));//绝对值
        System.out.println(Math.sqrt(64));//开方
        System.out.println(Math.pow(5, 2));//5的平方
        System.out.println(Math.pow(2, 5));//2的5次方
        //Math类中常用的常量
        System.out.println(Math.PI);//常数π
        System.out.println(Math.E);//常数E
        //随机数
        System.out.println(Math.random());// [0,1)之间的随机数
    }
}
