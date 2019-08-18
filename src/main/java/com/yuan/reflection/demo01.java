package com.yuan.reflection;

/**
 * Created by 朱承才 on 2019/8/18.
 *测试反射获取类
 */
public class demo01 {

    public static void main(String[] args) {

        String path = "com.yuan.reflection.bean.testBean";


        try {
            /*通过Class.forName获取类对象*/
            Class c = Class.forName(path);
            System.out.println(c);

            /*通过.class获取类对象*/
            Class c2 = String.class;
            /*通过对象的.getClass也可以获取*/
            Class c3 = path.getClass();   //path是一个String对象
            System.out.println(c2==c3);

            //基本数据类型也可以获得相应的类对象
            Class intclazz = int.class;
            System.out.println("-----------------------------");
            //同样元素类型，同样维度的数组共享同一个类对象
            int[] arr01 = new int[10];
            int[] arr02 = new int[20];
            int[][] arr03 = new int[10][5];
            System.out.println(arr01.getClass().hashCode());
            System.out.println(arr02.getClass().hashCode());
            System.out.println(arr03.getClass().hashCode());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
