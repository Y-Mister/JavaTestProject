package com.yuan.CommonsIOStudy;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;

/**
 * Author:helloboy
 * Date:2019-07-29 18:10
 * Description:文件的拷贝
 */
public class commonsIOTest04 {
    public static void main(String[] args) throws IOException {
        //文件的复制
        //FileUtils.copyFile(new File("zzf.jpg"),new File("zzf5.jpg"));
        //复制文件到目录
       // FileUtils.copyFileToDirectory(new File("zzf.jpg"),new File("dest"));

        //复制目录,将dest目录下的内容复制到dest2中
        //FileUtils.copyDirectory(new File("dest"),new File("dest2"));
        //复制目录到目录,将dest作为dest3的子目录
        //.copyDirectoryToDirectory(new File("dest"),new File("dest3"));


        //拷贝URL内容
        String Url = "https://www.baidu.com";
       /* FileUtils.copyURLToFile(new URL(Url),new File("copybaidu.txt"));*/

        //将url内容拷贝到字符串中
        String string = IOUtils.toString(new URL(Url), "UTF-8");
        System.out.println(string);
    }
}
