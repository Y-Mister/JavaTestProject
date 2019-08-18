package com.yuan.reflection;

import com.yuan.reflection.bean.testBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by 朱承才 on 2019/8/18.
 */
public class demo03 {

    public static void main(String[] args) {
        //动态操作构造器
        String path = "com.yuan.reflection.bean.testBean";

         /*通过Class.forName获取类对象*/
        try {
            Class c = Class.forName(path);//此处可以使用泛型，那么下面将不需要转型Class<testBean> c =(Class<testBean>) Class.forName(path);
            //通过动态调用构造方法，构造对象
            testBean bean = (testBean) c.newInstance();//通过反射使用无参构造器，必须有无参构造器，否则将报错
            System.out.println(bean);

            /*获得有参构造器并使用*/
            Constructor<testBean> constructor = c.getDeclaredConstructor(String.class,int.class,int.class);
            testBean bean1 = constructor.newInstance("老王", 1001, 21);//新建对象实例
            System.out.println(bean1.getName());

            System.out.println("----------------------");
            /*通过反射API调用普通方法*/
            testBean bean2 = (testBean) c.newInstance();
            //通过反射获得方法
            Method method = c.getDeclaredMethod("setName",String.class);
            method.invoke(bean2,"老李");//invoke激活，对应于bean2.setName("老李")
            System.out.println(bean2.getName());

            System.out.println("--------------------------");
            /*通过反射操作属性*/
            testBean bean3 = (testBean) c.newInstance();
           //通过反射获得指定属性
            Field field = c.getDeclaredField("name");
            field.setAccessible(true);
            field.set(bean3,"老刘");//此处若直接设置，是无法对private属性进行设置的,必须设置accessible，private方法也一样需要设置
            System.out.println(bean3.getName());//此处直接通过对象方法获得属性值
            System.out.println(field.get(bean3));//通过反射获取属性值


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
