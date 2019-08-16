package com.yuan.CollectionTest;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:helloboy
 * Date:2019-07-22 15:28
 * Description:<描述>
 */
public class testHashSet {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("aa");
        set.add("bb");
        set.add("cc");
        set.add("aa");
        System.out.println(set);
    }
}
