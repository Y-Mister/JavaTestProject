package com.yuan.ThreadCommunication;

/**
 * Author:helloboy
 * Date:2019-08-04 20:37
 * Description:<描述>
 */
public class happenBefore {

    private static int a=0;
    private static boolean flag=false;
    public static void main(String[] args) throws InterruptedException {
        //线程一读取数据
        Thread t1 = new Thread(()->{
            a = 1;
            flag=true;
        });
        //线程二更改数据
        Thread t2 = new Thread(()->{
            if (flag){
                a*= 1;
            }
            //此处出现指令重排
            if (a==0){
                System.out.println("happen before a-->"+a);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
