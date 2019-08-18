package com.yuan.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by 朱承才 on 2019/8/18.
 * 应用反射API获取类的信息，类名，属性，方法，构造器
 */
public class demo02 {
    public static void main(String[] args) {
        String path = "com.yuan.reflection.bean.testBean";

        try {
            /*通过Class.forName获取类对象*/
            Class c = Class.forName(path);

            //获取类名
            System.out.println(c.getName());//获得全名
            System.out.println(c.getSimpleName());//获得类名
            System.out.println("--------------------------");
            //获得属性
            Field[] field = c.getFields();//只能返回public属性
            Field[]  field2 = c.getDeclaredFields();//返回所有属性
            System.out.println(field.length+field2.length);
            for (Field temp:field2){
                System.out.println("属性:"+temp);
            }
            Field name = c.getDeclaredField("name");//通过名称获取指定属性
            System.out.println(name);
            System.out.println("----------------------------");
            //获得方法
            // c.getMethod(""); c.getMethods(); 只能获得public方法
            //获得全部方法则用以下方法
            Method[] methods = c.getDeclaredMethods();
            for (Method temp:methods){
                System.out.println("方法："+temp);
            }
            //通过方法名第二个参数表示要取得的方法的传入参数类型,如果有参，必须传入对于参数类型的类对象，这是因为java有重载，所以通过参数进行区分
            Method nameSetter = c.getDeclaredMethod("setName",String.class);
            Method nameGetter = c.getDeclaredMethod("getName",null);

            System.out.println("---------------------------");
            //获得构造器
            Constructor[] constructors = c.getConstructors();//获得public构造器
            Constructor[] constructors1 = c.getDeclaredConstructors();//获得所有构造器
            for (Constructor temp : constructors1){
                System.out.println("构造器："+temp);
            }
            //获得指定构造器
            Constructor constructor = c.getDeclaredConstructor(null);//获得空构造器
            Constructor constructor1 = c.getDeclaredConstructor(String.class,int.class,int.class);//通过参数类型获得指定构造器
            System.out.println(constructor);
            System.out.println(constructor1);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
