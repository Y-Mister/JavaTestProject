package com.yuan.ThreadTest02;

/**
 * Author:helloboy
 * Date:2019-08-01 21:47
 * Description:<描述>
 */
public class BlockedSleep01 {

    public static void main(String[] args) {
        //一份资源
        Web12306 web = new Web12306();
        //多个代理
        new Thread(web,"老王").start();
        new Thread(web,"老李").start();
        new Thread(web,"老刘").start();
    }
}

class Web12306 implements Runnable {

    //票数
    private int ticketNum=99;
    @Override
    public void run() {
        while (true){
            if (ticketNum<=0){
                break;
            }
            //模拟延时

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ticketNum--;
            System.out.println(Thread.currentThread().getName()+"买了一张票，还剩："+ticketNum+"张票");

        }
    }


}