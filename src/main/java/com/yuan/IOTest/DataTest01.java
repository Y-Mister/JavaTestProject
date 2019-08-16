package com.yuan.IOTest;

import java.io.*;

/**
 * Author:helloboy
 * Date:2019-07-28 15:11
 * Description:
 * 数据流
 * 先写出后读取
 * 读取顺序应与写出顺序保持一致
 *
 * DataInputStream
 * DataOutputStream
 */
public class DataTest01 {

    public static void main(String[] args) throws IOException {
        //写出
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(bos));
        //操作
        dos.writeUTF("编码辛酸泪");
        dos.writeBoolean(true);
        dos.writeInt(155);
        dos.writeChar('C');
        dos.flush();
        byte[] bytes = bos.toByteArray();
        //读取
        DataInputStream dis = new DataInputStream(
                                new BufferedInputStream(
                                    new ByteArrayInputStream(bytes)));
        String s = dis.readUTF();
        boolean b = dis.readBoolean();
        int i = dis.readInt();
        char c = dis.readChar();
        System.out.println(s+" "+b+" "+i+" "+c);
        //读取时的顺序一定要与写入是相一致，否则将报错

        dos.close();
        dis.close();
    }
}
