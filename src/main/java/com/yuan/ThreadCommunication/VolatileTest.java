package com.yuan.ThreadCommunication;

/**
 * Author:helloboy
 * Date:2019-08-04 21:09
 * Description:<描述>
 */
public class VolatileTest {
    private volatile static int num=0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (num==0){//死循环

            }
        }).start();
        Thread.sleep(1000);
        num=1;
        new Thread().start();
    }
}
