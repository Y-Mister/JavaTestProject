package com.yuan.sync;

/**
 * Author:helloboy
 * Date:2019-08-03 21:29
 * Description:<描述>
 */
public class unsafe {

    public static void main(String[] args) {
        //一份资源
        UnsafeWeb12306 web = new UnsafeWeb12306();
        //多个代理
        new Thread(web,"老王").start();
        new Thread(web,"老李").start();
        new Thread(web,"老刘").start();
    }
}


class UnsafeWeb12306 implements Runnable {

    //票数
    private int ticketNum = 10;
    private boolean flag=true;
    @Override
    public void run() {
        while (flag) {
            test();
        }
    }

    private void test(){
        if (ticketNum <= 0) {
            flag=false;
            return;
        }
        try {
            Thread.sleep(200);
            ticketNum--;
            System.out.println(Thread.currentThread().getName() + "买了一张票，还剩：" + ticketNum + "张票");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}