package com.yuan.ThreadTest;

/**
 * Author:helloboy
 * Date:2019-08-01 15:19
 * Description:创建线程方法一，继承thread，重写run
 */
public class ThreadStudy01 extends Thread{


    @Override
    public void run() {
        for (int i=0;i<20;i++){
            System.out.println("一边听歌");
        }
    }

    public static void main(String[] args) {

        ThreadStudy01 ts = new ThreadStudy01();
        ts.start();//不保证立即执行，且要注意创建时机
        for (int i=0;i<20;i++){
            System.out.println("一边coding");
        }
    }


}
