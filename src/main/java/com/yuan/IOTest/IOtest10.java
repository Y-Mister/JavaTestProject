package com.yuan.IOTest;

import java.io.*;

/**
 * Author:helloboy
 * Date:2019-07-23 15:55
 * Description:文件->字节数组->文件
 * 已图片为例
 */
public class IOtest10 {

    public static void main(String[] args) {
        File src = new File("e:/zzf1.jpg");
        File dest = new File("zzf.jpg");
        FileInputStream fi = null;
        OutputStream os = null;
        ByteArrayOutputStream bo = null;

        try {

            fi = new FileInputStream(src);
            os = new FileOutputStream(dest);
            bo = new ByteArrayOutputStream();
            byte[] flush = new byte[1024*10];
            int len=-1;
            while ((len=fi.read(flush))!=-1){
                bo.write(flush,0,len);
            }
            bo.writeTo(os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
