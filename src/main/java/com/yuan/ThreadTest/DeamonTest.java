package com.yuan.ThreadTest;

/**
 * Author:helloboy
 * Date:2019-08-03 13:09
 * Description:守护线程为用户线程服务：JVM的停止不用等待守护线程执行完毕
 * 默认所有线程都是用户线程，jvm必须等待用户线程执行完毕才会停止
 */
public class DeamonTest {

    public static void main(String[] args) {
        God god = new God();
        Person person = new Person();
        god.setDaemon(true);//设置现场为守护现场，默认为false
        person.start();
        god.start();
    }
}

class Person extends Thread{
    @Override
    public void run() {
        for (int i=0;i<=365*100;i++){
            System.out.println("happy life....");
        }
        System.out.println("cooooo......");
    }
}
class God extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("God bless person....");
        }
    }
}
