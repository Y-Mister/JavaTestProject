package com.yuan.IOTest;

import java.io.File;

/**
 * Author:helloboy
 * Date:2019-07-22 21:29
 * Description:目录相关
 */
public class Dirdemo {


    public static void main(String[] args) {
        File file =new File("D:/电影/华语/test");
        System.out.println(file.mkdir());//确保上级目录一定要存在，不存在则创建失败
        System.out.println(file.mkdirs());//上级目录可以不存在，不存在则一同创建，推荐使用
        File src =new File("D:/电影");
        String[] subNames = src.list();//返回下级目录，只有一层
        for (String name:subNames){
            System.out.println(name);
        }

        File[] subfiles = src.listFiles();//返回下一层文件对象
        for (File ff:subfiles){
            System.out.println(ff.getAbsolutePath());
        }

        File[] fff = src.listRoots();//返回所有盘符
        for (File r:fff){
            System.out.println("盘符"+r.getAbsolutePath());
        }

    }


}
