package com.yuan.ThreadCommunication;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:helloboy
 * Date:2019-08-11 14:45
 * Description:比较并交换
 */
public class CASTest {

    private static AtomicInteger stock = new AtomicInteger(4);

    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            new Thread(()->{
                try {
                    Thread.sleep(1000);//模拟网络延时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer left = stock.decrementAndGet();
                if (left<0){
                    System.out.println("抢完了");
                    return;
                }
                System.out.print(Thread.currentThread().getName()+"抢到了商品");
                System.out.println("还剩"+left+"件商品");
            }).start();
        }
    }


}
