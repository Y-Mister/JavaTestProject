package com.yuan.IOTest;

import java.io.*;
import java.net.URL;

/**
 * Author:helloboy
 * Date:2019-07-27 23:25
 * Description:转换流操作,操作一个网络流，进行字符集设置
 */
public class ConvertTest02 {

    public static void main(String[] args) {


        test01();

    }
    /*未加缓冲进行处理*/
    public static void test01(){
        InputStreamReader is = null;
        try {
            is =new InputStreamReader(
                    new URL("http://www.baidu.com").openStream(),"utf-8");//网络流是一个字节流
            int temp;
            while ((temp=is.read())!=-1){
                System.out.println((char) temp);//此处出现乱码，可能是因为字符集不同导致字节数不够
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*加缓冲流进行处理*/
    public static void test02(){
        BufferedReader is = null;
        BufferedWriter bs = null;
        try {
            is =new BufferedReader(
                    new InputStreamReader(
                            new URL("http://www.baidu.com").openStream(),"utf-8"));//new URL("http://www.baidu.com").openStream()是一个网络流同时是一个字节流
            bs =new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("baidu.html"),"utf-8"));//若不指定字符集，则字符集将会与工程字符集相同
            String msg;
            while ((msg=is.readLine())!=null){
                bs.write(msg);//这里出现乱码可能是因为字符集不统一
                bs.newLine();
                bs.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                bs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
