package com.yuan.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Author:helloboy
 * Date:2019-07-21 15:26
 * Description:测试file类的基本内容
 */
public class fileTest {
    public static void main(String[] args) throws IOException {
        File f = new File("d:/magic.txt");
        System.out.println(f);//打印的是文件路径
        f.renameTo(new File("d:/magic2.txt"));//对文件改名

        System.out.println(System.getProperty("user.dir"));//当前用户的工作控空间

        File f2 = new File("gg.txt");
        //f2.createNewFile(); //创建新文件，不加路径，将会添加到当前的用户空间
        f2.delete();
        System.out.println("File是否存在："+f2.exists());
        System.out.println("File是否是目录："+f2.isDirectory());
        System.out.println("File是否是文件："+f2.isFile());
        System.out.println("File最后修改时间："+new Date(f2.lastModified()));
        System.out.println("File的大小："+f2.length());
        System.out.println("File的文件名："+f2.getName());
        System.out.println("File的目录路径："+f2.getPath());
    }
}
