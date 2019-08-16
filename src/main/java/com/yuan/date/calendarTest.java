package com.yuan.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Author:helloboy
 * Date:2019-07-21 14:05
 * Description:<描述>
 */
public class calendarTest {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2999,10,9,22,10,50);//构造方法有很多，此处为年月日时分秒
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);//获得几号,也可用DAY_OF_MONTH
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);//星期几，1-7对应
        System.out.println(year+" "+month+" "+" "+day+" "+weekday);//0-11表示对应的月份

        //设置日期相关元素
        Calendar calendar1 = new GregorianCalendar();//不添加参数，结果为当前时间的日期
        calendar1.set(Calendar.YEAR,8012);//设置当前年份


        //日期的计算
        Calendar c3 = new GregorianCalendar();
        c3.add(Calendar.DATE,100);//在当前日期上加100天,参数一是待修改参数，参数二是实际修改的数量
        System.out.println(c3);


        //日期对象与时间对象的转化
        Date d4 = c3.getTime();//calendar转date
        System.out.println(d4);
        Calendar c4 = new GregorianCalendar();
        c4.setTime(new Date());//date转calendar
        calendarTest.printCalendar(c4);
    }


    public static void printCalendar(Calendar c){

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;//1-12
        int day = c.get(Calendar.DATE);
        int weekDay = c.get(Calendar.DAY_OF_WEEK)-1;
        String weekDay2 = weekDay==0?"日":weekDay+"";

        int hour = c.get(Calendar.HOUR);
        int min = c.get(Calendar.MINUTE);
        int sec = c.get(Calendar.SECOND);

        System.out.println(year+"年"+month+"月"+day+"日"+hour+"时"+min+"分"+sec+"秒 星期"+weekDay2);


    }
}
