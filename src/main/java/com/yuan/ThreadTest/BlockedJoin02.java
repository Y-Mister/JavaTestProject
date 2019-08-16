package com.yuan.ThreadTest;

/**
 * Author:helloboy
 * Date:2019-08-03 12:22
 * Description:<描述>
 */
public class BlockedJoin02 {

    public static void main(String[] args) {
        System.out.println("爸爸和儿子买烟的故事。");
        Thread father = new Father();
        father.start();
    }
}

class Father extends Thread{

    @Override
    public void run() {
        System.out.println("爸爸想抽烟，发现烟没了。");
        System.out.println("让儿子去买烟。");
        Thread son = new Son();
        son.start();
        try {
            son.join();//father线程被阻塞
            System.out.println("爸爸开心的抽起了烟！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Son extends Thread{

    @Override
    public void run() {
        System.out.println("儿子去买烟，需要十分钟");
        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("儿子去买烟，已经"+i+"分钟了");
        }
        System.out.println("儿子买烟回来的。");
    }
}
