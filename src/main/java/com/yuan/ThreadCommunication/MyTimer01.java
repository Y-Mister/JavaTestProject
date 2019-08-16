package com.yuan.ThreadCommunication;

import java.util.*;

/**
 * Author:helloboy
 * Date:2019-08-04 16:16
 * Description:<描述>
 */
public class MyTimer01 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        //timer.schedule(new MyTask(),1000);//执行任务一次
        //timer.schedule(new MyTask(),1000,500);//一秒后执行一次，此后每隔500毫秒执行一次
        Calendar calendar = new GregorianCalendar(2019,7,4,16,36);
        timer.schedule(new MyTask(),calendar.getTime(),200);//指定某一个具体的时间开始执行，之后没200毫秒执行一次
    }
}

class MyTask extends TimerTask{

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println("放松一下大脑，休息一会");
        }
        System.out.println("----------休息结束-------");
    }
}
