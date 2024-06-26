package com.xaut.api.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
        /* 需求:
            秒杀活动开始时间:2023年11月11日 0:0:0(毫秒值)
            秒杀活动结束时间:2023年11月11日 0:10:0(毫秒值)

            小贾下单并付款的时间为:2023年11月11日 0:01:0
            小皮下单并付款的时间为:2023年11月11日 0:11:0
            用代码说明这两位同学有没有参加上秒杀活动?
         */

public class SimpleDateFormatTest2 {
    public static void main(String[] args) throws ParseException {
        //1.定义字符串表示三个时间
        String startstr = "2023年11月11日 0:0:0";
        String endstr = "2023年11月11日 0:10:0";
        String orderstr1 = "2023年11月11日 0:01:00";
        String orderstr2 = "2023年11月11日 0:11:0";

        //2.使用SimpleDateFormat得到对应的date对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 H:mm:ss");
        Date startDate = sdf.parse(startstr);
        Date endDate = sdf.parse(endstr);
        Date orderDate1 = sdf.parse(orderstr1);
        Date orderDate2 = sdf.parse(orderstr2);

        //3.使用gettime得到时间
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        long orderTime1 = orderDate1.getTime();
        long orderTime2 = orderDate2.getTime();

        if (orderTime1 >= startTime && orderTime1 <= endTime) {
            System.out.println("小贾秒杀成功");
        } else {
            System.out.println("小贾秒杀失败");
        }

        if (orderTime2 >= startTime && orderTime2 <= endTime) {
            System.out.println("小皮秒杀成功");
        } else {
            System.out.println("小皮秒杀失败");
        }

    }
}
