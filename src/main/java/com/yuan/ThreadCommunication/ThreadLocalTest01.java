package com.yuan.ThreadCommunication;

/**
 * Author:helloboy
 * Date:2019-08-04 21:46
 * Description:
 *
 */
public class ThreadLocalTest01 {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();//初始值为null
    //更改初始值为非null
    //方法1：
    /*private static ThreadLocal<Integer> threadLocal = new ThreadLocal(){
        @Override
        protected Integer initialValue() {
            return 200;
        }
    };*/
    //方法2：
    /*private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->{
        return 200;
    });*/
    public static void main(String[] args) {
        //设置值
        threadLocal.set(100);
        System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());

        new Thread(new myRun()).start();
    }

    public static class myRun implements Runnable{
        //如此，每个线程虽然使用同一个ThreadLocal,但是保有的都是自己的值，更改不会影响其他线程
        @Override
        public void run() {
            //threadLocal.set(150);若不设置，将为默认值null
            System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
        }
    }

}



