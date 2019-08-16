package com.yuan.IOTest;

import java.io.UnsupportedEncodingException;

/**
 * Author:helloboy
 * Date:2019-07-22 21:59
 * Description:字符串-->字节：编码
 */
public class fileEncoding {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "性命生命使命";
        //编码encode：字节数组
        byte[] datas = msg.getBytes();//默认使用工程的字符集
        System.out.println(datas.length);//GBK一个汉字2个字节

        datas = msg.getBytes("utf-8");
        System.out.println(datas.length);
        datas = msg.getBytes("utf-16LE");
        System.out.println(datas.length);

        //解码decode 字节->字符串
        msg = new String(datas,"utf-16LE");//一定要给出正确的编码，否则会乱码，此外重载的方法还有很多
        System.out.println(msg);
    }
}
