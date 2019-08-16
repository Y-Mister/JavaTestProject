package com.yuan.ThreadTest;

/**
 * Author:helloboy
 * Date:2019-08-03 13:25
 * Description:线程的常用方法总结
 */
public class InfoTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().isAlive());
        //设置名称：真实角色+代理角色
        MyInfo info = new MyInfo("战斗机");
        Thread t = new Thread(info);
        t.setName("公鸡中的");//设置线程名称，即代理名称
        t.start();
        Thread.sleep(1000);
        System.out.println(t.isAlive());//在主线程内对其他线程的状态判断需要延时处理，这是运行特性决定的
    }
}


class MyInfo implements Runnable{

    private String name; //真实名称

    public MyInfo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+name);
    }
}
