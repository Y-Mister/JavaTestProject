package com.yuan.IOTest;

import java.io.*;

/**
 * Author:helloboy
 * Date:2019-07-27 23:25
 * Description:转换流操作
 */
public class ConvertTest {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//字节流转换为字符流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//字符流转换为字节流
        String msg ="";
        try {
            while (!"exit".equals(msg)){
                    msg = br.readLine();
                    bw.write(msg);
                    bw.newLine();
                    bw.flush();//使用缓冲流，一定要注意，当你的数据流未达到内部缓冲区大小时，缓冲流将不会做输出处理，需要强制刷新
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
