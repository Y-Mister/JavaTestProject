package com.yuan.IOTest;

import java.io.*;

/**
 * Author:helloboy
 * Date:2019-07-23 10:04
 * Description:文件字节输入流分段读取
 */
public class IOTest02 {

    public static void main(String[] args) {
        File file = new File("D:/magic2.txt");
        InputStream is = null;

        try {
            is= new FileInputStream(file);
            //int temp;
            byte[] flush = new byte[1024];//字节数组长度取决于你想读取的字节长度
            int len=-1;
            while((len=is.read(flush))!=-1){
                //字节数组到字符串
                String str= new String(flush,0,len);//解码，要取实际大小，否则会将垃圾读入
                System.out.print(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
