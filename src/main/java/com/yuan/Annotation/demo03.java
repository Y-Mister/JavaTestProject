package com.yuan.Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Author:袁航
 * Date:2019-08-11 22:15
 * Description:通过反射读取注解的信息，模拟处理注解信息流程
 */
public class demo03 {

    public static void main(String[] args) {
        try {
            //通过反射获取类的全部信息
            Class relStudent = Class.forName("com.yuan.Annotation.RefStudent");
            //获得该类上的所有注解
            Annotation[] annotations = relStudent.getDeclaredAnnotations();
            for (Annotation annotation:annotations){
                System.out.println(annotation);
            }
            //通过注解类获取类的指定注解
            StuTable table = (StuTable) relStudent.getAnnotation(StuTable.class);
            System.out.println(table);

            //获得类的属性注解,先获取属性，在通过属性获取属性的注解
            Field name = relStudent.getDeclaredField("studentName");
            stuField stuField = name.getAnnotation(stuField.class);
            System.out.println(stuField.columnName()+"-->"+stuField.type()+"--"+stuField.length());

            //根据获得的表明字段等信息，就可以拼接出sql语句
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
