package com.yuan.ThreadTest;

/**
 * Author:helloboy
 * Date:2019-08-01 20:51
 * Description:<描述>
 */
public class lambdaTest04 {

    public static void main(String[] args) {

        new Thread(()->{

            System.out.println("一边学习lambda");
        }).start();

        new Thread(()->{
            System.out.println("一边泪流满面");
        }).start();
    }

}
