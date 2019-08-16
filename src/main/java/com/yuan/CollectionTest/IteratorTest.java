package com.yuan.CollectionTest;

import java.util.*;

/**
 * Author:helloboy
 * Date:2019-07-22 17:55
 * Description:测试迭代器
 */
public class IteratorTest {

    public static void main(String[] args) {
       // testList();
        //testSet();
        testMap1();
        //testMap2();
    }

    public static void testList(){
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        Iterator<String> iterator = list.iterator();
        for (;iterator.hasNext();){//是否存在下一个元素
            String str = iterator.next();   //取出元素
            System.out.println(str);
        }

    }

    public static void testSet(){
        Set<String> set = new HashSet<>();
        set.add("123");
        set.add("456");
        set.add("789");
        Iterator<String> iterator = set.iterator();
        for (;iterator.hasNext();){//是否存在下一个元素
            String str = iterator.next();   //取出元素
            System.out.println(str);
        }
    }

    public static void testMap1(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"123");
        map.put(2,"456");
        map.put(3,"789");
        Set<Map.Entry<Integer,String>> ss = map.entrySet();

        for (Iterator< Map.Entry<Integer,String> > Item = ss.iterator();Item.hasNext();){
            Map.Entry<Integer,String > temp = Item.next();

            System.out.println(temp.getKey()+":"+temp.getValue());

        }
    }

    public static void testMap2(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"123");
        map.put(2,"456");
        map.put(3,"789");
        Set<Integer> ss = map.keySet();

        for (Iterator<Integer> Item = ss.iterator();Item.hasNext();){
            Integer temp = Item.next();

            System.out.println(map.get(temp));

        }
    }

}
