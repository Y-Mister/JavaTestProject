package com.yuan.sync;

/**
 * Author:helloboy
 * Date:2019-08-04 9:28
 * Description:<描述>
 */
public class synTest02 {

    public static void main(String[] args) {
        //一份资源
        synWeb12306 web = new synWeb12306();
        //多个代理
        new Thread(web,"老王").start();
        new Thread(web,"老李").start();
        new Thread(web,"老刘").start();
    }
}


class synWeb12306 implements Runnable {

    //票数
    private int ticketNum = 10;
    private boolean flag=true;
    @Override
    public void run() {
        while (flag) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test5();
        }
    }
    //线程安全，同步
    private synchronized void test1(){
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
    //同样能够成功锁住资源
    private void test2(){
        synchronized(this){
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
    //存疑！无法锁住资源，因为ticketNum的值始终在变，无法锁住同一对象，所以使用锁一定要锁住地址不变的对象，同时flag也没有被锁住
    private void test3(){
        synchronized(Integer.valueOf(ticketNum)){
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

    //缩小同步块的范围，无法锁住资源
    private void test4(){
        synchronized(this){
            if (ticketNum <= 0) {
                flag=false;
                return;
            }
        }
            try {
                Thread.sleep(200);
                ticketNum--;
                System.out.println(Thread.currentThread().getName() + "买了一张票，还剩：" + ticketNum + "张票");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

    //锁住合理的范围（数据的完整性），提高性能与效率，此处为双重检测，考虑临界值的问题
    private void test5(){
        if (ticketNum <= 0) {//没票的情况下，避免其他线程等待
            flag=false;
            return;
        }
        synchronized(this){
            if (ticketNum <= 0) { //考虑最后一张票的情况
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
}