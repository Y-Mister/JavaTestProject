package com.yuan.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author:helloboy
 * Date:2019-07-21 13:13
 * Description:<描述>
 */
public class dateText {
    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str = df.format(new Date());
        System.out.println(str);


        DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        Date date = df2.parse("1983年05月10日 10时35分49秒");
        System.out.println(date);

        //查看今天2019-7-21是今年的多少天
        DateFormat df3 = new SimpleDateFormat("w");
        String str2 = df3.format(new Date());
        System.out.println(str2);
    }
}
