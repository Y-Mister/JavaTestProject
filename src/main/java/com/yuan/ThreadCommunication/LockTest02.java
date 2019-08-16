package com.yuan.ThreadCommunication;

/**
 * Author:helloboy
 * Date:2019-08-11 11:47
 * Description:可可重入锁
 */
public class LockTest02 {
    ReLock lock = new ReLock();

    public void a() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        b();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }

    public void b() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        System.out.println("i'm doing sth");
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest02 lockTest02 = new LockTest02();
        lockTest02.a();
        //lockTest02.b();

        Thread.sleep(1000);
        System.out.println(lockTest02.lock.getHoldCount());
    }

}

class  ReLock{
    //是否占用
    private boolean isLocked = false;
    Thread lockedBy = null;//存储线程，如果获取锁的仍然是当前对象，则跳过wait
    private int holdCount = 0;
    //使用锁
    public synchronized void lock() throws InterruptedException {
        Thread t = Thread.currentThread();
        while (isLocked&&lockedBy!=t){
            wait();   //此处wait陷入死循环，导致不可重入
        }
        isLocked=true;
        lockedBy=t;
        holdCount++;
    }

    public synchronized void unlock(){

        if (Thread.currentThread()==lockedBy){
            holdCount--;
            if (holdCount==0){
                isLocked=false;
                notify();
                lockedBy=null;
            }
        }
    }

    public int getHoldCount() {
        return holdCount;
    }
}

