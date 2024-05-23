package com.xaut.string;

import java.util.Scanner;

public class Statistics {
    public static void main(String[] args) {
        /*键盘录入一个字符串，统计该字符串中大写字母字符，小写字母字符，数字字符出现的次数(不考虑其他字符)*/

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String str = sc.next();

        int bigCount = 0;
        int smallCount = 0;
        int numberCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                smallCount++;
            }else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                bigCount++;
            }else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                numberCount++;
            }
        }

        System.out.println("大写字母有" + bigCount + "个");
        System.out.println("小写字母有" + smallCount + "个");
        System.out.println("数字字母有" + numberCount + "个");
    }

}