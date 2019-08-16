package com.yuan.IOTest;

import java.io.File;
import java.io.IOException;

/**
 * Author:helloboy
 * Date:2019-07-22 20:11
 * Description:名称或路径
 */
public class fileDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("D:/magic2.txt");
        System.out.println(file.getName());//获取文件名称
        System.out.println(file.getPath());//获得路径
        System.out.println(file.getAbsolutePath());//获得绝对路径
        System.out.println(file.getParent());//取出传入路径最后有一个分割符前面的内容，有就打印，没有就是null
        System.out.println(file.getParentFile().getName());//获取父对象
        System.out.println(file.exists());//文件是否存在
        System.out.println(file.isFile());//是否是文件
        System.out.println(file.isDirectory());//是否是文件夹
        System.out.println(file.length());//如果是文件，返回文件长度，否则返回0
        File src = new File("IO.txt");
        System.out.println(src.createNewFile());//文件不存在，则创建文件，如果文件本来存在，将创建失败
        System.out.println(src.delete());//删除已经存在的文件

        //补充con com3...是操作系统设备名，无法进行创建
        src = new File("con");
        System.out.println(src.createNewFile());//无法创建

    }
}
