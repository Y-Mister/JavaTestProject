package com.yuan.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Author:helloboy
 * Date:2019-07-21 14:32
 * Description:可视化日期练习
 */
public class CalendarTest2 {

    public static void main(String[] args) throws ParseException {
        System.out.println("请输入日期：（格式为：2020-09-15）");
        Scanner reader = new Scanner(System.in);
        String str = reader.nextLine();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(str);//字符串转化为格式化日期对象,两者格式需相同
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("日\t一\t二\t三\t四\t五\t六\t");
        calendar.set(Calendar.DAY_OF_MONTH,1);

        for (int i=0;i<calendar.get(Calendar.DAY_OF_WEEK)-1;i++){//先计算出当前月的第一天是周几，将其放置于正确的位置上
            System.out.print("\t");
        }
        int maxDay = calendar.getActualMaximum(Calendar.DATE);//获取当前月份一共多少天
        for (int i=1;i<=maxDay;i++){
            if (calendar.get(Calendar.DAY_OF_MONTH)==currentDay){
                System.out.print(calendar.get(Calendar.DAY_OF_MONTH)+"*\t");
            }else{
                System.out.print(calendar.get(Calendar.DAY_OF_MONTH)+"\t");
            }
            if (calendar.get(Calendar.DAY_OF_WEEK)== Calendar.SATURDAY){//每逢周六换行
                System.out.println();
            }
            calendar.add(Calendar.DAY_OF_MONTH,1);
        }

    }
}
