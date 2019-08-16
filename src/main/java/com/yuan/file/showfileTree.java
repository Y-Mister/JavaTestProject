package com.yuan.file;

import java.io.File;

/**
 * Author:helloboy
 * Date:2019-07-21 15:55
 * Description:<描述>
 */
public class showfileTree {
    public static void main(String[] args) {
        File file = new File("d:/电影");
        showfileTree.printFileTree(file,0);


    }

    static void printFileTree(File file,int level){
        for (int i=0;i<level;i++){
            System.out.print("-");
        }
        System.out.println(file.getName());
        if (file.isDirectory()){
            File[] files = file.listFiles();//如果当前文件是目录，列出其下所有文件
            for(File temp:files) {
                printFileTree(temp,level+1);
            }
        }
    }
}
