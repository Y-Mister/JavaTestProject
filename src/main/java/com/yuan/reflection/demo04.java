package com.yuan.reflection;

import com.yuan.reflection.bean.testBean;

import java.lang.reflect.Method;

/**
 * Created by 朱承才 on 2019/8/18.
 * 反射的效率验证
 */
public class demo04 {
    public static void test01(){
        testBean bean1 = new testBean();
        long startTime = System.currentTimeMillis();
        for (int i=0; i < 1000000000L;i++ ){
            bean1.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法执行，执行时间："+(endTime-startTime)+" ms");
    }

    public static void test02(){
        try {
            testBean bean1 = new testBean();
            Class c = Class.forName("com.yuan.reflection.bean.testBean");
            //testBean bean2 = (testBean) c.newInstance();
            Method getname = c.getDeclaredMethod("getName",null);
            long startTime = System.currentTimeMillis();
            for (int i=0; i < 1000000000L;i++ ){
                getname.invoke(bean1,null);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("普通反射方法执行，执行时间："+(endTime-startTime)+" ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test03(){
        try {
            testBean bean1 = new testBean();
            Class c = Class.forName("com.yuan.reflection.bean.testBean");
            //testBean bean2 = (testBean) c.newInstance();
            Method getname = c.getDeclaredMethod("getName",null);
            getname.setAccessible(true);
            long startTime = System.currentTimeMillis();
            for (int i=0; i < 1000000000L;i++ ){
                getname.invoke(bean1,null);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("关闭语法检查，反射方法执行，执行时间："+(endTime-startTime)+" ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test01();
        test02();
        test03();
    }
}
