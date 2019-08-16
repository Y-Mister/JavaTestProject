package com.yuan.ThreadCommunication;

/**
 * Author:helloboy
 * Date:2019-08-04 22:02
 * Description:<描述>
 */
public class ThreadLocalTest03 {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1);

    public static void main(String[] args) {

            new Thread(new myRun3()).start();

    }

    public static class myRun3 implements Runnable{

        public myRun3() {
            System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get()); //此处为main线程的threadlocal,原因是执行此构造方式是是在main线程中执行的，新的线程还没有start，只有在run方法线程体中的代码才属于新线程上下文
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
        }
    }
}
