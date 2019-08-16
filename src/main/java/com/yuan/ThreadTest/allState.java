package com.yuan.ThreadTest;

import java.lang.Thread.State;
/**
 * Author:helloboy
 * Date:2019-08-03 12:36
 * Description:<描述>
 */
public class allState {

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i=0;i<5;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("这里是线程体的运行代码");
        });
        State state = t.getState();
        System.out.println(state.toString());//新生状态，属于NEW

        t.start();
        state = t.getState();
        System.out.println(state);//就绪与run状态，统称为Runnable

        while (state!= State.TERMINATED){ //当线程运行完毕，状态为TERMINATED
            try {
                Thread.sleep(200);
                state = t.getState();
                System.out.println(state);//在线程体中加入了有时间的等待，是阻塞的一种，成为TIMED_WAITING
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
