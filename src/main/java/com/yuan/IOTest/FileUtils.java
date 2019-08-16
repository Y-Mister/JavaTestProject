package com.yuan.IOTest;

import java.io.*;

/**
 * Author:helloboy
 * Date:2019-07-23 20:58
 * Description:封装拷贝，封装资源释放
 */
public class FileUtils {

    public static void main(String[] args) {
            //文件到文件
        try {
            InputStream is = new FileInputStream("abc.txt");
            OutputStream os = new FileOutputStream("abc-copy.txt");
            copy(is,os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //文件到字节数组
        byte[] datas = null;
        try {
            InputStream is = new FileInputStream("zzf.jpg");
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            copy(is,bo);
            datas = bo.toByteArray();
            System.out.println(bo.size());
            System.out.println(datas.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //字节数组到文件
        try {
            OutputStream os2 = new FileOutputStream("zzf2.jpg");
            ByteArrayInputStream bo = new ByteArrayInputStream(datas);
            copy(bo,os2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    /*
    * 对接输入输出流，进行拷贝
    * */
    public static void copy(InputStream is,OutputStream os){//利用顶层抽象类保证数据传入

        try {
            byte[] flush = new byte[1024];
            int len=-1;
            while ((len=is.read(flush))!=-1){
                os.write(flush,0,len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void close(InputStream is,OutputStream os){

        try {
            if (os!=null)
                os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (is!=null)
                is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void close(Closeable... ios){//可变参数

        for (Closeable io:ios){
            try {
                if (io!=null)
                    io.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

}
