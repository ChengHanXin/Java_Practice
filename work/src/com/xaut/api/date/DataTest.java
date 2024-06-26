package com.xaut.api.date;

import java.util.Date;

public class DataTest {
    public static void main(String[] args) {
        Date date = new Date(0L);
        date.setTime(1718525412735L);
        System.out.println(date);
        System.out.println(date.getTime());
    }
}
