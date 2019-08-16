package com.yuan.ThreadCommunication;

/**
 * Author:helloboy
 * Date:2019-08-04 22:13
 * Description:
 */
public class ThreadLocalTest04 {

    private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
    //InheritableThreadLocal将会延续上下文的threadlocal值
    public static void main(String[] args) {
        threadLocal.set(2);
        System.out.println(Thread.currentThread().getName() + "--->"+threadLocal.get());
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
            threadLocal.set(200);
            System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());

        }).start();//因为当前线程由main线程开辟，所以他的threadlocal初始值与main线程相同,是从main线程的threadlocal中拷贝得到，但后续更改仍然不是共享
    }
}
