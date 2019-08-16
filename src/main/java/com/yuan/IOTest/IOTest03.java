package com.yuan.IOTest;

import java.io.*;

/**
 * Author:helloboy
 * Date:2019-07-23 10:15
 * Description:文件字节输出流
 */
public class IOTest03 {

    public static void main(String[] args) {
        //创建源
        File file = new File("D:/magic3.txt");
        //选择流
        OutputStream os =null;
        InputStream is = null;
        try {
            os =  new FileOutputStream(file);//每次写入覆盖之前的文件内容,文件不存在将自动创建
            //os =  new FileOutputStream(file,true);//每次写入在之前的文件内容后追加
            String msg = "i'm studing io stream now";
            //编码准备写入
            byte[] datas = msg.getBytes();
            os.write(datas,0,datas.length);
            os.flush();//强制刷新，避免文件驻留内存中

            File file1 = new File("D:/magic3.txt");
            is = new FileInputStream(file1);
            byte[] flush = new byte[1024];
            int len=-1;
            while ((len=is.read(flush))!=-1){
                //解码
                String str = new String(flush,0,flush.length);
                System.out.println(str);
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null!=os){
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
