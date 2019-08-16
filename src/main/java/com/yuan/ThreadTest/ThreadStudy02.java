package com.yuan.ThreadTest;

/**
 * Author:helloboy
 * Date:2019-08-01 15:19
 * Description:创建线程方法而，实现runnable，重写run
 */
public class ThreadStudy02 implements Runnable{


    @Override
    public void run() {
        for (int i=0;i<20;i++){
            System.out.println("一边听歌");
        }
    }

    public static void main(String[] args) {

        ThreadStudy02 ts = new ThreadStudy02();
        //创建代理类对象
        new Thread(ts).start();//不保证立即执行，且要注意创建时机
        /*若该对象只使用一次，可以使用匿名方式创建*/
        new Thread(new ThreadStudy02()).start();
        for (int i=0;i<20;i++){
            System.out.println("一边coding");
        }
    }


}
