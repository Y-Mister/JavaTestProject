package com.yuan.CommonsIOStudy;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Author:helloboy
 * Date:2019-07-29 17:50
 * Description:读取文件
 */
public class commonsIOTest02 {

    public static void main(String[] args) throws IOException {
        //读取文件
        String msg = FileUtils.readFileToString(new File("copy.txt"),"utf-8");
        System.out.println(msg);
        System.out.println("======================================");
        byte[] datas = FileUtils.readFileToByteArray(new File("copy.txt"));
        System.out.println(datas.length);

        System.out.println("======================================");
        //逐行读取
        List<String> msg2 = FileUtils.readLines(new File("copy.txt"), "utf-8");
        for (String str:msg2){
            System.out.println(str);
        }
        System.out.println("======================================");
        //逐行读取，迭代器方法LineIterator
        LineIterator lineIterator = FileUtils.lineIterator(new File("copy.txt"), "utf-8");
        while (lineIterator.hasNext()){
            System.out.println(lineIterator.next());
        }
    }
}
