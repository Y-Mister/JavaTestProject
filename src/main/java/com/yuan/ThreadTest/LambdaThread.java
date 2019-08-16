package com.yuan.ThreadTest;

/**
 * Author:helloboy
 * Date:2019-08-01 15:19
 * Description:
 * Lambda表达式，针对简单的只使用一次的线程进行简化
 */
public class LambdaThread {
    /*静态内部类*/
    static class Test implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<20;i++){
                System.out.println("一边听歌");
            }
        }
    }


    public static void main(String[] args) {


        //new Thread(new Test()).start(); 1.静态内部类方式的简化

        //2.局部内部类方式的简化
        class Test2 implements Runnable{

            @Override
            public void run() {
                for (int i=0;i<20;i++){
                    System.out.println("一边听歌");
                }
            }
        }
        new Thread(new Test2()).start();

        //3.匿名内部类方式的简化 必须借助接口或者父类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<20;i++){
                    System.out.println("一边听歌");
                }
            }
        }).start();


        //4.JDK8进一步简化 使用lambda表达式,注意lambda只能推导一个方法，多个方法无法推导
        new Thread(  ()-> {
                for (int i=0;i<20;i++){
                    System.out.println("一边听歌");
                }
        }).start();
    }


}
