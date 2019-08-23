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
                    System.out.println(i+"  开始睡觉");
                    Thread.sleep(900);
                } catch (Exception e) {
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
                System.out.println("开始睡觉");
                Thread.sleep(2000); //main线程sleep阻塞
                state = t.getState();
                System.out.println("线程当前状态"+state);//在线程体中加入了有时间的等待，是阻塞的一种，成为TIMED_WAITING
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
    /**
     * 输出结果分析：程序共两个线程，main线程睡眠2秒，t线程睡眠1秒，由结果可知当main线程sleep后，t线程进入运行态，由于t线程睡眠时间为1秒，所以t线程共运行了两次，之后main线程苏醒开始；
     * 如果线程t睡眠时间设置为0.9秒，那么t线程将运行三次，其后t线程在睡眠时间main线程占用cpu，而t线程状态为TIMED_WAITING,如果是sleep，则main线程运行时t线程的状态将是block
     */
}
