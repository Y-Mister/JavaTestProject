package com.yuan.IOTest;

import java.io.*;

/**
 * Author:helloboy
 * Date:2019-07-23 15:16
 * Description:字节数组输入流
 *
 */
public class IOTest08 {

    public static void main(String[] args) {
        //创建源：字节数组 不要太大
        byte[] src = "talk is cheap show me the code".getBytes();

        InputStream fi=null;
        try {
            //选择流
            fi = new ByteArrayInputStream(src);
            //操作
            byte[] flush = new byte[5];
            int len=-1;
            while ((len=fi.read(flush))!=-1){
                String str = new String(flush,0,len);
                System.out.println(str);

            }
            //释放资源：可以不用处理

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
