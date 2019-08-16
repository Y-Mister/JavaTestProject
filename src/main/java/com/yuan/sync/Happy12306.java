package com.yuan.sync;

/**
 * Author:helloboy
 * Date:2019-08-04 10:25
 * Description:<描述>
 */
public class Happy12306 {

    public static void main(String[] args) {
        SnyWeb12306 c = new SnyWeb12306(2,"浦口火车站");
        Passenger passenger=new Passenger(c,"老王",2);
        Passenger passenger2=new Passenger(c,"老李",1);
        passenger.start();
        passenger2.start();
    }

}


class Passenger extends Thread{
    int seats;
    public Passenger(Runnable target, String name, int seats) {
        super(target, name);
        this.seats = seats;
    }
}


class SnyWeb12306 implements Runnable{
    int available;
    String name;

    public SnyWeb12306(int available, String name) {
        this.available = available;
        this.name = name;
    }

    @Override
    public void run() {
        Passenger passenger = (Passenger)Thread.currentThread();
        boolean flag = this.bookTickets(passenger.seats);
        if (flag){
            System.out.println("购票成功:"+passenger.getName()+"->购票"+passenger.seats+"张");
        }else{
            System.out.println("购票失败，余票不足");
        }
    }

    public synchronized boolean bookTickets(int seats){

        if (seats>available){
            return false;
        }
        available-=seats;
        return true;
    }
}