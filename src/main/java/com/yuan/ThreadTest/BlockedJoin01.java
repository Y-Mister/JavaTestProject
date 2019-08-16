package com.yuan.ThreadTest;

/**
 * 插队线程
 * Author:helloboy
 * Date:2019-08-03 12:15
 * Description:<描述>
 */
public class BlockedJoin01 {

    public static void main(String[] args) {

        Thread t = new Thread(()->{
            for (int i=0;i<20;i++){
                System.out.println("lambda....."+i);
            }
        });
        t.start();

        for (int j=0;j<20;j++){
            if (j==10){
                try {
                    t.join();//插队，阻塞main线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("main...."+j);
        }
    }
}
