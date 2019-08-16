package com.yuan.ThreadCommunication;

/**
 * Author:helloboy
 * Date:2019-08-11 11:47
 * Description:不可重入锁
 */
public class LockTest01 {
    Lock lock = new Lock();

    public void a() throws InterruptedException {
        lock.lock();
        b();
        lock.unlock();
    }

    public void b() throws InterruptedException {
        lock.lock();
        System.out.println("i'm doing sth");
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest01 lockTest01 = new LockTest01();
        lockTest01.a();
        lockTest01.b();
    }

}


class  Lock{
    //是否占用
    private boolean isLocked = false;
    //使用锁
    public synchronized void lock() throws InterruptedException {
        while (isLocked){
            wait();   //此处wait陷入死循环，导致不可重入
        }
        isLocked=true;
    }

    public synchronized void unlock(){
        isLocked=false;
        notify();
    }
}