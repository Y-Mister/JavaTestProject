package com.yuan.ThreadCommunication;

/**
 * Author:helloboy
 * Date:2019-08-04 20:49
 * Description:<描述>
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("这是线程t1");
        });
        Thread t2 = new Thread(()->{
            System.out.println("这是线程t2");
        });
        Thread t3 = new Thread(()->{
            System.out.println("这是线程t3");
        });
        Thread t4 = new Thread(()->{
            System.out.println("这是线程t4");
        });
        Thread t5 = new Thread(()->{
            System.out.println("这是线程t5");
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        System.out.println("这是线程main");
    }
}
