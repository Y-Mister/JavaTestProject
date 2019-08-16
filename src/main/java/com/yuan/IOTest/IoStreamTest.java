package com.yuan.IOTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Author:helloboy
 * Date:2019-07-22 22:48
 * Description:理解操作步骤
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 */
public class IoStreamTest {

    public static void main(String[] args)  {
        //创建源
        File src = new File("abc.txt");
        FileInputStream fi=null;
        try {
            //选择流
            fi = new FileInputStream(src);
            //操作
            /*int data1 = fi.read();
            int data2 = fi.read();
            int data3 = fi.read();
            int data4 = fi.read();
            System.out.println((char)data1);
            System.out.println((char)data2);
            System.out.println((char)data3);
            System.out.println(data4);//文件末尾，返回-1*/
            int temp;
            while ((temp=fi.read())!=-1){
                System.out.println((char)temp);

            }
            //释放资源

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if (fi!=null)
                    fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
