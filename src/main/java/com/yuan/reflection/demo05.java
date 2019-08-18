package com.yuan.reflection;

import com.yuan.reflection.bean.testBean;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by 朱承才 on 2019/8/18.
 */
public class demo05 {

    public void test01(Map<String,testBean> map,List<testBean> list){
        System.out.println("demo05 test01");
    }

    public Map<Integer,testBean> test02(){
        System.out.println("demo05 test02");
        return null;
    }

    public static void main(String[] args) {

        try {
            //获得指定方法参数泛型信息
            Method m = demo05.class.getDeclaredMethod("test01",Map.class,List.class);
            Type[] types = m.getGenericParameterTypes(); //获得带泛型参数类型

            for (Type paramType:types){
                System.out.println("#"+paramType);//输出参数类型
                if (paramType instanceof ParameterizedType){//是否是参数化类型
                    Type[] gengricTypes = ((ParameterizedType) paramType).getActualTypeArguments();//获得参数中的泛型
                    for (Type geneicType:gengricTypes){
                        System.out.println("泛型类型："+geneicType);
                    }
                }
            }

            Method m2 = demo05.class.getDeclaredMethod("test02",null);
            Type returnType = m2.getGenericReturnType();//得到一个方法的正式返回类型
            if (returnType instanceof ParameterizedType){  //是否是参数化类型
                Type[] types1 = ((ParameterizedType) returnType).getActualTypeArguments();//获得参数化类型
                for (Type generictype:types1){
                    System.out.println("返回值泛型类型："+generictype);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
