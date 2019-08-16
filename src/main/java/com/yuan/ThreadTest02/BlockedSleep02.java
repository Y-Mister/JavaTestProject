package com.yuan.ThreadTest02;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author:helloboy
 * Date:2019-08-01 21:56
 * Description:<描述>
 */
public class BlockedSleep02 {
    public static void main(String[] args) throws InterruptedException {
        //倒计时
        Date endTime = new Date(System.currentTimeMillis()+1000*10);
        long end=endTime.getTime();
        while (true){
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            Thread.sleep(1000);
            endTime = new Date(endTime.getTime()-1000);
            if (end-10000>endTime.getTime()){
                break;
            }

        }
    }

    public static void test() {
        //倒数十个数
        int num=10;

        while (num>0){
            System.out.println(num);
            try {
                Thread.sleep(1000);
                num--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
