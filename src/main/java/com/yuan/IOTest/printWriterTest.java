package com.yuan.IOTest;

import java.io.*;

/**
 * Author:helloboy
 * Date:2019-07-28 16:10
 * Description:<描述>
 */
public class printWriterTest {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //打印
        PrintWriter ps = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("print.txt")),true);//true表示自动刷新
        ps.println("这是打印流");
        ps.close();

    }
}
