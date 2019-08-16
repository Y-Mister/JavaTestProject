package com.yuan.IOTest;

import java.io.*;

/**
 * Author:helloboy
 * Date:2019-07-23 10:51
 * Description:递归拷贝文件夹
 */
public class IOTest05 {

    public static void main(String[] args) {

        File file = new File("D:/电影");
        File destFile = new File("E:/");
        listDir(file,destFile);

    }


    public static void listDir(File file,File destFile){

        if (file.isDirectory()){
            File newFile = new File(destFile.getAbsolutePath(),file.getName());
            newFile.mkdirs();
            File[] files = file.listFiles();
            for (File file1:files){
                listDir(file1,newFile);
            }

        }else{
            File newFile = new File(destFile.getAbsoluteFile(),file.getName());
            copy(file.getAbsolutePath(),newFile.getAbsolutePath());
            return;
        }



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
