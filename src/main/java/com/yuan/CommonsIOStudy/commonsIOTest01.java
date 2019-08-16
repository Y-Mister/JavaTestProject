package com.yuan.CommonsIOStudy;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.util.Collection;

/**
 * Author:helloboy
 * Date:2019-07-29 15:19
 * Description:<描述>
 */
public class commonsIOTest01 {

    public static void main(String[] args) {
        //文件大小
        long len = FileUtils.sizeOf(new File("zzf.jpg"));
        //目录大小
        long len2 = FileUtils.sizeOf(new File("F:/JetBrains project/javaBaseTest"));
        System.out.println(len+" "+len2);
        //子孙集,共三个参数，目录，文件过滤器，目录过滤器,其返回值是一个文件集合Collection
        //事例1：
       /* Collection<File> files = FileUtils.listFiles(new File("F:/JetBrains project/javaBaseTest"), EmptyFileFilter.NOT_EMPTY, null);//列出目录下所有非空文件，只列出第一层
        for (File file:files){
            System.out.println(file.getAbsolutePath());
        }*/

        //事例2：
        /*Collection<File> files2 = FileUtils.listFiles(new File("F:/JetBrains project/javaBaseTest"), EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);//列出目录下所有非空文件，列出所有子孙集
        for (File file:files2){
            System.out.println(file.getAbsolutePath());
        }*/

        //事例3：
        /*Collection<File> files3 = FileUtils.listFiles(new File("F:/JetBrains project/javaBaseTest"), new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);//列出目录下所有.java文件
        for (File file:files3){
            System.out.println(file.getAbsolutePath());
        }*/

        //事例4：文件过滤器的or方法使用
        /*Collection<File> files4 = FileUtils.listFiles(new File("F:/JetBrains project/javaBaseTest"), FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class")), DirectoryFileFilter.INSTANCE);//列出目录下.java与.class文件，
        for (File file:files4){
            System.out.println(file.getAbsolutePath());
        }*/

        //事例5：文件过滤器的and方法使用
        Collection<File> files5 = FileUtils.listFiles(new File("F:/JetBrains project/javaBaseTest"), FileFilterUtils.and(new SuffixFileFilter("java"), EmptyFileFilter.NOT_EMPTY), DirectoryFileFilter.INSTANCE);//列出目录下.java且不为空的文件
        for (File file:files5){
            System.out.println(file.getAbsolutePath());
        }
    }
}
