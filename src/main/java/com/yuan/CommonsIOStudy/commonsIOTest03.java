package com.yuan.CommonsIOStudy;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:helloboy
 * Date:2019-07-29 17:59
 * Description:<描述>
 */
public class commonsIOTest03 {

    public static void main(String[] args) throws IOException {
        //写出文件,在字符串下，两函数功能相同
        FileUtils.write(new File("commonsIOtest.txt"),"学习真的很不容易","utf-8",false);
        FileUtils.writeStringToFile(new File("commonsIOtest.txt"),"我很迷茫","utf-8",true);//最后的布尔型变量表示是否追加

        //写入到文件，字节数组方式
        FileUtils.writeByteArrayToFile(new File("commonsIOtest.txt"),"我该怎么面对他们".getBytes("utf-8"),true);

        //写出列表
        List<String> list = new ArrayList<>();
        list.add("马云");
        list.add("马化腾");
        list.add("弼马温");
        FileUtils.writeLines(new File("commonsIOtest.txt"),list,"--",true);

    }
}
