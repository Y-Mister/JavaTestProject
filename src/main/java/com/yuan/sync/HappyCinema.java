package com.yuan.sync;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:helloboy
 * Date:2019-08-04 9:58
 * Description:<描述>
 */
public class HappyCinema {

    public static void main(String[] args) {
        List<Integer> avaliable = new ArrayList<>();
        avaliable.add(1);
        avaliable.add(2);
        avaliable.add(3);
        avaliable.add(6);
        avaliable.add(7);
        List<Integer> seats1 = new ArrayList<>();
        seats1.add(2);
        seats1.add(3);
        List<Integer> seats2 = new ArrayList<>();
        seats2.add(1);
        seats2.add(2);
        seats2.add(3);

        Cinema cinema = new Cinema(avaliable,"幸福蓝海");
        Customer customer = new Customer(cinema,seats1);
        Customer customer1 = new Customer(cinema,seats2);
        new Thread(customer,"老王").start();
        new Thread(customer1,"老李").start();
    }
}

//顾客
class Customer implements Runnable{
    Cinema cinema;
    List<Integer> seats;//位置数

    public Customer(Cinema cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema){
            boolean flag = cinema.bookTickets(seats);
            if (flag){
                System.out.println("出票成功-->"+Thread.currentThread().getName()+"购买了"+seats+"张票");
            }else {
                System.out.println("出票失败，位置不足");
            }
        }

    }
}



//影院
class Cinema{
    List<Integer> available;//可用位置
    String name;

    public Cinema( List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    public boolean bookTickets(List<Integer> seats){
        System.out.println("可用位置为："+available);
        List<Integer> copy = new ArrayList<>();
        copy.addAll(available);

        //可用座位减去想选的座位
        copy.removeAll(seats);
        if (available.size()-copy.size()!=seats.size()){
            return false;
        }

        //操作成功
        available=copy;
        return true;
    }
}
