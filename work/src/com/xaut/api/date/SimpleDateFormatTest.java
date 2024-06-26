package com.xaut.api.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
        /*
         假设，你初恋的出生年月日为:2000-11-11
         请用字符串表示这个数据，并将其转换为:2000年11月11日

         创建一个Date对象表示2000年11月11日
         创建一个SimpleDateFormat对象，并定义格式为年月日把时间变成:2000年11月11日
        */

public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {

        String str = "2000-11-11";
        //解析 字符串-->Date对象
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(str);
        //格式化 Date对象-->字符串
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
        String res = sdf2.format(date);
        System.out.println(res);
    }
}
