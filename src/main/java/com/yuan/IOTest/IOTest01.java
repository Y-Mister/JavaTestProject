package com.yuan.IOTest;

import java.io.*;

/**
 * Author:helloboy
 * Date:2019-07-23 9:59
 * Description:<描述>
 */
public class IOTest01 {

    public static void main(String[] args) {

        File file = new File("D:/magic2.txt");
        InputStream is = null;

        try {
            is= new FileInputStream(file);
            int temp;
            while((temp=is.read())!=-1){
                System.out.print((char)temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
