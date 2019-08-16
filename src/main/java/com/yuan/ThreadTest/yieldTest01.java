package com.yuan.ThreadTest;

/**
 * Author:helloboy
 * Date:2019-08-03 12:08
 * Description:<描述>
 */
public class yieldTest01 {

    public static void main(String[] args) {
        new Thread(()->{
            for (int i=0;i<100;i++)
                System.out.println("lambda......"+i);
        }).start();

        for (int j=0;j<100;j++){
            if (j%30==0)
                Thread.yield();

            System.out.println("main....."+j);
        }
    }
}
