package com.yuan.ThreadTest;

/**
 * Author:helloboy
 * Date:2019-08-01 15:52
 * Description:使用Runnable共享资源
 */
public class Web12306 implements Runnable {

    //票数
    private int ticketNum=99;
    @Override
    public void run() {
        while (true){
            if (ticketNum<=0){
                break;
            }
            ticketNum--;
            System.out.println(Thread.currentThread().getName()+"买了一张票，还剩："+ticketNum+"张票");

        }
    }

    public static void main(String[] args) {
        //一份资源
        Web12306 web = new Web12306();
        //多个代理
        new Thread(web,"老王").start();
        new Thread(web,"老李").start();
        new Thread(web,"老刘").start();
    }
}
