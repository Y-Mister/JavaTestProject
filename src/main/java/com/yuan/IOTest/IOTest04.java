package com.yuan.IOTest;

import java.io.*;

/**
 * Author:helloboy
 * Date:2019-07-23 10:34
 * Description:文件的拷贝,可以封装成方法
 */
public class IOTest04 {

    public static void main(String[] args) {
        copy("src/main/java/com/yuan/IOTest/IOTest03.java","IO.java");

    }

    public static void copy(String srcPath,String destPath){
        //创建源 输入与输出文件
        File src = new File(srcPath);
        File dest = new File(destPath);
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            byte[] flush = new byte[3];
            int len=-1;
            while ((len=is.read(flush))!=-1){
                os.write(flush,0,len);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭流，一个小知识先打开的后关闭
                if (os!=null){
                    os.close();
                }

                if (is!=null){
                    is.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }


}
