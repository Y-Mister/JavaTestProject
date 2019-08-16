package com.yuan.ThreadCommunication;

/**
 * Author:helloboy
 * Date:2019-08-04 21:20
 * Description:单例模式：懒汉式套路基础上加入并发控制，在多线程环境下，对外存在一个对象
 * 1.构造器私有化
 * 2.提供私有静态属性，存储一个对象地址
 * 3.提供公共静态方法-->获取属性
 * */
public class DoubleChecking {
    //2.提供私有静态属性
    private static volatile DoubleChecking instace;//此处如果直接new一个对象，则称为饿汉式，如果想当前这样空着，则称为懒汉式
    //若不加volatile，则可能导致其他进程访问一个未初始化的空对象
    //1.构造器私有化
    private DoubleChecking(){

    }

    public static DoubleChecking getInstance(){
        //此处为Double-Checking
        if (null!=instace){
            return instace;
        }
        synchronized (DoubleChecking.class){
            if (null==instace){
                instace = new DoubleChecking();
                //new一个对象的步骤
                //开辟空间、初始化对象信息、返回对象地址给引用
                //可能存在的指令重排情况：初始化对象耗时，将一个空对象返回给引用，避免的方法，给instance加volatile,保证对象修改后同步
            }
            return instace;
        }
    }

    public static void main(String[] args) {
            Thread t =new Thread(()->{
                System.out.println(DoubleChecking.getInstance());
            });
            t.start();
            Thread t2 =new Thread(()->{
                System.out.println(DoubleChecking.getInstance());
            });
            t2.start();
    }


}
