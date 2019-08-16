package com.yuan.IOTest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Author:helloboy
 * Date:2019-07-28 20:40
 * Description:面向对象思想封装文件分割
 */
public class SplitFileUtil {
    //源头
    private File src;
    //目的地
    private File dest;
    //所有文件分割后的存储路径
    private List<String> destPath;
    //每块大小
    private int blocKSize;
    //总文件块数
    private int size;

    public SplitFileUtil(String srcPath,String destDir ,int blocKSize ) {
        this.blocKSize = blocKSize;
        this.dest = new File(destDir);
        this.src = new File(srcPath);
        this.destPath = new ArrayList<>();
        init();
    }
    //初始化
    private void init(){
        //总长度
        long len = this.src.length();
        //块数
        this.size= (int) Math.ceil(len*1.0/blocKSize);
        //路径
        for (int i=0;i<size;i++){
            this.destPath.add(this.dest+"/"+i+this.src.getName());
            System.out.println(this.dest+"/"+i+this.src.getName());
        }
    }
    /*分割
    * 计算每一块的起始位置
    * 分割
    * */
    public void split() throws IOException {
        //总长度
        long len = this.src.length();
        int beginPos=0;
        int actualSize=0;//(int)(blocKSize>len?len:blocKSize)
        for (int i=0;i< size;i++){
            beginPos=i*blocKSize;
            if (i==size-1){
                actualSize= (int) len;
            }else{
                actualSize = blocKSize;
                len-=actualSize;
            }
            splitDetail(i,beginPos,actualSize);
        }
    }

    //分块读取初级，读取指定大小的块，起始位置，实际大小
    public void splitDetail(int i,int beginPos,int actualSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(this.src,"r");
        RandomAccessFile raf2 = new RandomAccessFile(this.destPath.get(i),"rw");
        raf.seek(beginPos);
        byte[] flush = new byte[100];
        int len;
        while ((len=raf.read(flush))!=-1){
            if (actualSize>len){//获取本次读取的全部内容
                raf2.write(flush,0,len);
                actualSize-=len;
            }else{
                raf2.write(flush,0,actualSize);
                break;
            }
        }


        raf2.close();
        raf.close();
    }

    public void merge(String destDir) throws IOException {
        //输出流
        OutputStream os = new BufferedOutputStream(new FileOutputStream(destDir,true));

        for (int i=0;i<size;i++){
            //输入流
            InputStream is = new BufferedInputStream(new FileInputStream(destPath.get(i)));
            byte[] flush = new byte[1024];
            int len=-1;
            while ((len=is.read(flush))!=-1){
                os.write(flush,0,len);
            }
            os.flush();
            is.close();
        }
        os.close();

    }

    public void merge2(String destDir) throws IOException {
        //输出流
        OutputStream os = new BufferedOutputStream(new FileOutputStream(destDir,true));
        Vector<InputStream> Vis = new Vector<InputStream>();
        SequenceInputStream sis = null;
        for (int i=0;i<size;i++) {
            //输入流
            Vis.add(new BufferedInputStream(new FileInputStream(destPath.get(i))));
        }
        sis=new SequenceInputStream(Vis.elements());
        byte[] flush = new byte[1024];
        int len=-1;
        while ((len=sis.read(flush))!=-1){
            os.write(flush,0,len);
        }
        os.flush();
        sis.close();
        os.close();

    }

    public static void main(String[] args) throws IOException {
        SplitFileUtil sfu = new SplitFileUtil("zzf.jpg","dest",1024*10);
        sfu.split();

        sfu.merge2("zzf4.jpg");

    }
}
