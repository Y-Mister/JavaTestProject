package com.yuan.sync;

/**
 * Author:helloboy
 * Date:2019-08-04 14:28
 * Description：过多的同步导致互不释放
 */
public class DeadLock {

    public static void main(String[] args) {
        /*MakeUp girl1 = new MakeUp(0,"小红");
        MakeUp girl2 = new MakeUp(1,"小丽");
        girl1.start();
        girl2.start();*/
    }
}

/*class lipstick{


}

class mirror{

}

class MakeUp extends Thread{
    static lipstick stick = new lipstick();
    static mirror mir = new mirror();
    //选择
    int choice;
    String girl;

    public MakeUp(int choice, String girl) {
        this.choice = choice;
        this.girl = girl;
    }

    @Override
    public void run() {

        makeup();
    }
    //相互持有对方的对象锁，就可能造成死锁
    private void makeup(){
        if (choice==0){
            synchronized (stick){
                System.out.println(girl +"获得口红");
                //1秒后想拥有镜子的锁
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mir){
                    System.out.println(girl+"照镜子");
                }
            }
        }else{
            synchronized (mir){
                System.out.println(girl+"照镜子");

                //2秒后想拿到口红
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (stick) {
                    System.out.println(girl + "获得口红");
                }
            }
        }
    }
}*/
