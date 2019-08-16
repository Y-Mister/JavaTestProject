package com.yuan.file;

import java.io.File;

/**
 * Author:helloboy
 * Date:2019-07-21 15:45
 * Description:<描述>
 */
public class mkdirTest {
    public static void main(String[] args) {
        File f2 = new File("d:/电影/华语/大陆");
        //boolean flag = f2.mkdirs();//目录结构中有一个不存在也没关系；创建整个目录树
        //System.out.println(flag);//创建成功
        f2.delete();
    }
}
