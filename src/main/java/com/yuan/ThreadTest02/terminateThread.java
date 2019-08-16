package com.yuan.ThreadTest02;

/**
 * Author:helloboy
 * Date:2019-08-01 21:32
 * Description:<描述>
 */
public class terminateThread implements Runnable {
    //标志位，标志线程体是否允许
    private boolean flag = true;
    private String name;
    @Override
    public void run() {
        int i=0;
        while (flag){
            i++;
            System.out.println(name+"-->"+i);
        }
    }

    //对外提供改变标识符的方法一达到结束线程的目的
    public void terminate(){
        this.flag=false;
    }

    public terminateThread(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        terminateThread terminateThread = new terminateThread("乌龟");
        new Thread(terminateThread).start();

        for (int i =0;i<=99;i++){
            if (i==10){
                System.out.println("线程该终止了");
                terminateThread.terminate();//线程终止
                break;
            }
            System.out.println("main-->"+i);
        }
    }

}
