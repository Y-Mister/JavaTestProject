package com.yuan.ThreadCommunication;

/**
 * Author:helloboy
 * Date:2019-08-04 15:36
 * Description:<描述>
 */
public class CoTest02 {

    public static void main(String[] args) {

        Tv tv = new Tv();
        Actor actor = new Actor(tv);
        Wathcer wathcer = new Wathcer(tv);
        actor.start();
        wathcer.start();
    }
}
//生产者演员
class Actor extends Thread{
    Tv tv;

    public Actor(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i=0;i<20;i++){
            if (i%2==0){
                this.tv.play("奇葩说");
            }else{
                this.tv.play("广告");
            }
        }
    }
}
//消费者观众
class Wathcer extends Thread{
    Tv tv;

    public Wathcer(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i=0;i<20;i++){
            tv.watch();
        }
    }
}
//同一个资源电视
class Tv{
    String voice;
    //信号灯 True表示演员表演观众等待，false表示观众观看，演员等待
    boolean flag =true;

    //表演
    public synchronized void play(String voice){
        //观众观看，演员等待
        if (flag==false){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //演员表演
        System.out.println("演员表演了"+voice);
        this.voice=voice;
        this.notifyAll();
        //表演完毕，该观众观看了
        this.flag=!this.flag;
    }
    //观看
    public synchronized void watch(){
        //演员表演
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //观看时刻
        System.out.println("观众听到了"+voice);
        this.notifyAll();
        //切换标志
        this.flag=!this.flag;
    }

}