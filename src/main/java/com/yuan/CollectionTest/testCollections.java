package com.yuan.CollectionTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author:helloboy
 * Date:2019-07-22 18:29
 * Description:Collections辅助类的使用，是工具类，不是接口
 */
public class testCollections {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i =0;i<10;i++){
            list.add("这是："+i);
        }
        System.out.println(list);

        Collections.shuffle(list);//随机排列list中的元素
        System.out.println(list);

        Collections.reverse(list);//逆序排列
        System.out.println(list);

        Collections.sort(list);//按照递增方式排序，自定义类需实现comparable接口
        System.out.println(list);

        System.out.println(Collections.binarySearch(list,"这是：5"));//二分查找值的具体位置

    }
}
