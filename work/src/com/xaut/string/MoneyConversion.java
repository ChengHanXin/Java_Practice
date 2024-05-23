package com.xaut.string;

import java.util.Scanner;

public class MoneyConversion {
    public static void main(String[] args) {
        /*把2135变成：零佰零拾零万贰仟壹佰叁拾伍元
        把789变成：零佰零拾零万零仟柒佰捌拾玖元*/

        //键盘输入待转换金额
        Scanner sc = new Scanner(System.in);
        int money;
        while (true){
            money = sc.nextInt();
            if (money >= 0 && money <= 9999999){
                break;
            } else {
                System.out.println("Not a valid money");
            }
        }

        //金额转换
        String moneyStr = "";
        while (money != 0){
            int digit = money % 10;
            money /= 10;
            //根据数字去查找对应的大写数字
            moneyStr = numberToChar(digit) + moneyStr;
        }
        //补零
        int zeroCount = 7 - moneyStr.length();
        for (int i = 0; i < zeroCount; i++){
            moneyStr = "零" + moneyStr;
        }
        //添加单位
        String[] arr = {"佰","拾","万","仟","佰","拾","元"};
        String result = "";
        for (int i = 0; i < moneyStr.length(); i++){
            result = result + moneyStr.charAt(i) + arr[i];
        }
        System.out.println(result);
    }

    public static String numberToChar(int number){
        String[] arr = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        return arr[number];
    }
}
