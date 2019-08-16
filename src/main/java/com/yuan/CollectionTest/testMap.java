package com.yuan.CollectionTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:helloboy
 * Date:2019-07-22 12:14
 * Description:<描述>
 */
public class testMap {

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"张三");
        map.put(2,"张四");
        map.put(3,"王五");
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.containsKey(2));
        System.out.println(map.containsValue("王二麻子"));
        System.out.println(map.get(1));

        Map<Integer,String> map2 = new HashMap<>();
        map2.put(4,"老李");
        map2.put(5,"老刘");
        map.putAll(map2);
        System.out.println(map);
        map.put(3,"4564");
        System.out.println(map);
    }
}
