package com.yuan.ThreadTest;

/**
 * Author:helloboy
 * Date:2019-08-01 16:03
 * Description:<描述>
 */
public class TortoiseAndRabbit implements Runnable {
    private String Winner;
    @Override
    public void run() {
        for (int step=1;step<=100;step++){
            //模拟兔子休息
            if (Thread.currentThread().getName().equals("rabbit")&&step%50==0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"走到:"+step);
            boolean flag = gameOver(step);
            if (flag){
                break;
            }
        }
    }

    private boolean gameOver(int step){
        if (Winner!=null){
            return true;
        }else{
            if (step==100){
                Winner = Thread.currentThread().getName();
                System.out.println("winner==>"+Winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TortoiseAndRabbit racer = new TortoiseAndRabbit();
        new Thread(racer,"rabbit").start();
        new Thread(racer,"tortoise").start();
    }

}
