package com.yuan.sync;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:helloboy
 * Date:2019-08-03 21:56
 * Description:操作容器
 */
public class unsafe03 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i=0;i<20;i++){
            new Thread(()-> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        /*Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        /*for (String temp:list){
            System.out.println(temp);
        }*/
        System.out.println(list.size());
    }

}
