package com.yuan.IOTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Author:helloboy
 * Date:2019-07-23 15:23
 * Description:字节数组输出流
 *
 */
public class IOTest09 {

    public static void main(String[] args) {
        //创建源：原则上字节数组输出流是没有源头的，这里是为了保持和之前的风格统一
        byte[] dest = null;

        //选择流,此处要用到ByteArrayOutputStream特有的方法，所有不能用父类来定义即不能使用多态
        ByteArrayOutputStream os = null;
        try {
        os = new ByteArrayOutputStream();
        //操作
        String str = "Show me the code";
        byte[] msg = str.getBytes();
        os.write(msg,0,msg.length);
        os.flush();
        dest = os.toByteArray();
            System.out.println(dest.length+"--->"+new String(dest,0,dest.length));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
