package com.xaut.test;

import java.util.Scanner;

public class NumberChaiFeng {
    public static void main(String[] args) {
        // 从键盘获取数字
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个三位数：");
        int number = sc.nextInt();
        int ones = 0;
        int tens = 0;
        int hundreds = 0;
        // 开始拆分
        ones = number % 10;
        tens = (number / 10) % 10;
        hundreds = (number / 100) % 10;
        System.out.println("百位是：" + hundreds);
        System.out.println(tens);
        System.out.println(ones);
    }
}
