package com.yuan.IOTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Author:helloboy
 * Date:2019-07-23 11:30
 * Description:文件字符输入流
 */
public class IOTest06 {

    public static void main(String[] args) {
        //创建源
        File src = new File("abc.txt");
        //选择流
        FileReader fr = null;

        try {
            fr = new FileReader(src);
            char[] flush = new char[1024];//操作的是字符，所以要读入到字符数组中
            int len=-1;
            while ((len=fr.read(flush))!=-1){
                String str = new String(flush,0,len);
                System.out.println(str); //乱码，待解决
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
