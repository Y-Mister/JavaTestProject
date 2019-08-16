package com.yuan.CollectionTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:helloboy
 * Date:2019-07-21 20:58
 * Description:<描述>
 */
public class collectionTest {

    public static void main(String[] args) {
        test03();
    }

    public static void test01(){
        List<String> list01 = new ArrayList<>();
        list01.add("aa");
        list01.add("bb");
        list01.add("cc");
    }

    public static void test02(){
        List<String> list01 = new ArrayList<>();
        list01.add("aa");
        list01.add("bb");
        list01.add("cc");

        List<String> list02 = new ArrayList<>();
        list02.add("aa");
        list02.add("dd");
        list02.add("ee");
        System.out.println("list01:"+list01);

        list01.addAll(list02);//将list02的所有元素加入到list01
        System.out.println("list01:"+list01);

        list01.removeAll(list02);//移除list01与list02的交集元素
        System.out.println("list01:"+list01);

        list01.addAll(1,list02);//从list01的指定位置开始插入list02的全部值
        System.out.println("list01:"+list01);

        list01.retainAll(list02);//取两个list共同的元素，移除非交集元素
        System.out.println("list01:"+list01);

    }

    static void test03(){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println(list);
        list.add(2, "我");//指定位置添加
        System.out.println(list);
        list.remove(2);//指定位置移除
        System.out.println(list);
        list.set(2, "你");//指定位置替换
        System.out.println(list);
        list.add("你");
        System.out.println(list.get(2));//获取指定位置的值
        System.out.println(list);//获取指定位置的值
        System.out.println(list.indexOf("你"));//查询第一次出现的索引
        System.out.println(list.lastIndexOf("你"));//冲末尾向前查询首次出现的位置
    }


}
