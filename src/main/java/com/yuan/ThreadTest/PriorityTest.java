package com.yuan.ThreadTest;

/**
 * Author:helloboy
 * Date:2019-08-03 12:52
 * Description:<描述>
 */
public class PriorityTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());
        Myproority mp = new Myproority();
        Thread t1 = new Thread(mp,"mp1");
        Thread t2 = new Thread(mp,"mp2");
        Thread t3 = new Thread(mp,"mp3");
        Thread t4 = new Thread(mp,"mp4");
        Thread t5 = new Thread(mp,"mp5");
        Thread t6 = new Thread(mp,"mp6");
        //优先级的设置要在启动之前
        t1.setPriority(9);
        t2.setPriority(8);
        t3.setPriority(7);
        t4.setPriority(6);
        t5.setPriority(5);
        t6.setPriority(4);

        t3.start();
        t2.start();
        t1.start();
        t5.start();
        t4.start();
        t6.start();

    }
}

class Myproority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority());
    }
}