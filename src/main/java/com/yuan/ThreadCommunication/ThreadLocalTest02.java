package com.yuan.ThreadCommunication;

/**
 * Author:helloboy
 * Date:2019-08-04 22:02
 * Description:<描述>
 */
public class ThreadLocalTest02 {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1);

    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            new Thread(new myRun2()).start();
        }
    }

    public static class myRun2 implements Runnable{
        @Override
        public void run() {
            Integer num = threadLocal.get();
            System.out.println(Thread.currentThread().getName()+"得到了--->"+threadLocal.get());
            threadLocal.set(num-1);
            System.out.println(Thread.currentThread().getName()+"还剩下--->"+threadLocal.get());
        }
    }
}
