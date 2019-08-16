package com.yuan.CollectionTest;

import java.util.HashMap;

/**
 * Author:helloboy
 * Date:2019-07-22 15:35
 * Description:手工实现Hashset
 */
public class MyHashSet {

    HashMap map;
    private static final Object ppp = new Object();

    public MyHashSet() {
        map = new HashMap();
    }

    public void add(Object obj){
        map.put(obj,ppp);
    }

    @Override
    public String toString() {
        return "MyHashSet{" +
                "map=" + map +
                '}';
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(20);
        set.add(5);
        set.add(30);
        System.out.println(set);


    }
}
