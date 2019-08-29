package com.yuan.ThreadCommunication;

/**
 * Author:helloboy
 * Date:2019-08-04 15:13
 * Description:协作模型，管程法
 */
public class CoTest01 {

    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
}

//多线程生产者
class Producer extends Thread{
    SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //开始生产
        for (int i=1;i<=10;i++){
            System.out.println("生产-->第"+i+"个馒头");
            container.push(new Steamerbun(i));
        }
    }
}

//多线程消费者
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //开始消费
        for (int i=1;i<=10;i++){
            System.out.println("消费-->第"+container.pop().id+"个馒头");
        }
    }
}
//缓冲区
class SynContainer{
    Steamerbun[] buns = new Steamerbun[10];
    int count=0;
    //存放生产
    public synchronized void push(Steamerbun steamerbun){
        //什么时候可以生产
        if (count==buns.length){ //资源已满，无法生产，只能等待
            try {
                this.wait(); //线程阻塞，消费者通知生产，阻塞解除
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buns[count] = steamerbun;
        count++;
        this.notifyAll();//存在数据，可以通知消费者进行消费
    }
    //取出消费
    public synchronized Steamerbun pop()  {
        //消费的限制 容器中是否存在数据
        if (count==0){
            try {
                this.wait();//线程阻塞 生产者通知消费，则解除阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在数据 可以消费
        count--;
        Steamerbun bun = buns[count];
        this.notifyAll();//产生消费，存在空间了，可以唤醒生产者生产
        return bun;
    }

}
//馒头
class Steamerbun{
    int id;

    public Steamerbun(int id) {
        this.id = id;
    }
}