package com.yuan.IOTest;

import java.io.*;

/**
 * Author:helloboy
 * Date:2019-07-23 14:51
 * Description:字符输出流
 */
public class IOTest07 {

    public static void main(String[] args) {
        //创建源
        File src = new File("abc.txt");
        //选择流
        FileWriter fw = null;

        try {
            fw = new FileWriter(src);
            String str = "IO is easy action!\n这是";
            char[] array = str.toCharArray();//字符串转化为字符数组
            //写法一，可以进行部分写入
            // fw.write(array,0,array.length);
            //写法二：不需要部分写入，那么直接传入数据
            //fw.write(str);

            //写法三:适用于多次写入,是追加而不是覆盖
            fw.append("IO is easy action!\n");
            fw.append("aaaa");
            fw.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fw!=null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
