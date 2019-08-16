package com.yuan.IOTest;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Author:helloboy
 * Date:2019-07-28 16:42
 * Description:随机读取和写入流 RandomAccessFile
 */
public class RandomText01 {

    public static void main(String[] args) throws IOException {
        //分多少块
        File src = new File("src/main/java/com/yuan/IOTest/FileUtils.java");
        //总长度
        long len = src.length();
        //每块大小
        int blockSize = 1024;
        //总块数
        int size = (int) Math.ceil(len * 1.0 / blockSize);
        System.out.println(size);
        //起始位置与实际大小
        int beginPos=0;
        int actualSize = (int)(blockSize>len? len :blockSize);
        for (int i=0;i<size;i++){
            beginPos = i*blockSize;
            if (i==size-1){
                actualSize= (int) len;
            }else{
                actualSize=blockSize;
                len-=actualSize;
            }
            System.out.println("第"+i+"块：开始位置："+beginPos+"-->实际大小"+actualSize);
            split(beginPos,actualSize);
        }

    }
    //指定起始位置，读取剩下的所有内容
    public static void test01() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("src/main/java/com/yuan/IOTest/FileUtils.java"),"r");

        raf.seek(1024);
        byte[] flush = new byte[100];
        int len;
        while ((len=raf.read(flush))!=-1){
            String str = new String(flush,0,len);
            System.out.println(str);
        }


        raf.close();
    }
    //分块读取初级，读取指定大小的块，起始位置，实际大小
    public static void test02() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("src/main/java/com/yuan/IOTest/FileUtils.java"),"r");
        int beginPos = 2+1026;
        int actualSize=1026;
        raf.seek(beginPos);
        byte[] flush = new byte[100];
        int len;
        while ((len=raf.read(flush))!=-1){
            String str = new String(flush,0,len);
            if (actualSize>len){//获取本次读取的全部内容
                System.out.println(str);
                actualSize-=len;
            }else{
                System.out.println(new String(flush,0,actualSize));
                break;
            }
        }


        raf.close();

    }

    //分块读取初级，读取指定大小的块，起始位置，实际大小
    public static void split(int beginPos,int actualSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("src/main/java/com/yuan/IOTest/FileUtils.java"),"r");
        raf.seek(beginPos);
        byte[] flush = new byte[100];
        int len;
        while ((len=raf.read(flush))!=-1){
            if (actualSize>len){//获取本次读取的全部内容
                String str = new String(flush,0,len);
                System.out.println(str);
                actualSize-=len;
            }else{
                System.out.println(new String(flush,0,actualSize));
                break;
            }
        }


        raf.close();

    }
}
