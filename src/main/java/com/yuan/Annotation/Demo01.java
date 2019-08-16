package com.yuan.Annotation;

/**
 * Author:helloboy
 * Date:2019-08-11 15:49
 * Description:<描述>
 */
public class Demo01 {

    @Override
    public String toString(){
        return "";
    }

    @Deprecated
    public static void test(){
        System.out.println("不建议使用注解");
    }

    public static void main(String[] args) {
        test();
    }
}
