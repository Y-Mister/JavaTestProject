package com.yuan.ThreadCommunication;

/**
 * Author:helloboy
 * Date:2019-08-11 11:45
 * Description:<描述>
 */
public class LockTest {

    public void test(){
        synchronized(this){
            while(true){

                synchronized(this){  //此处再次获得同一个锁，计数器加1
                    System.out.println("ReentrantLock");
                }
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new LockTest().test();
    }
}
