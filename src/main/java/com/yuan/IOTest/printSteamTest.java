package com.yuan.IOTest;

import java.io.*;

/**
 * Author:helloboy
 * Date:2019-07-28 16:10
 * Description:<描述>
 */
public class printSteamTest {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //打印流
        PrintStream ps = System.out;
        ps.println("这是打印流");

        ps = new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream("print.txt")),true,"utf-8");//true表示自动刷新
        ps.println("这是打印流");
        ps.close();
        //重定向输出端,输出端需要是一个打印流
        System.setOut(ps);
        System.out.println("change");
        //重定向会控制台，控制台也是一个系统定义好的打印流
        System.setOut(
                new PrintStream(
                        new BufferedOutputStream(
                                new FileOutputStream(FileDescriptor.out)),true));//系统描述符，常量表示控制台
        System.out.println("重定向回控制台");
    }
}
