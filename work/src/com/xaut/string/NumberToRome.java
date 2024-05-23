package com.xaut.string;

import java.util.Scanner;

public class NumberToRome {
    public static void main(String[] args) {
        /*键盘录入一个字符串
            1.长度小于等于9
            2.只能是数字
         将内容转换为罗马数字*/

        Scanner sc = new Scanner(System.in);
        String str;
        //字符串合法判断
        while (true) {
            System.out.println("Enter a string: ");
            str = sc.next();
            if (str.length() <= 9) {
                if (isNumber(str)) {
                    break;
                } else {
                    System.out.println("输入含有除数字外的其他字符，请重新输入");
                }
            } else {
                System.out.println("字符串长度大于9，请重新输入");
            }
        }

        //转换
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
//            int num = str.charAt(i) - 48;
//            sb.append(toRome1(num));

            sb.append(toRome2(str.charAt(i)));
        }
        String result = sb.toString();
        System.out.println(result);

    }

    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    //使用数组查表思想转换
    public static String toRome1(int num) {
        String[] s = {"", "Ⅰ", "Ⅱ", "Ⅲ", "Ⅳ", "Ⅴ", "Ⅵ", "Ⅶ", "Ⅷ", "Ⅸ"};
        return s[num];
    }

    //使用switch转换，这样可以直接拿对应的字符来查找，不用转换为数字
    public static String toRome2(char s) {
//        String str = "";
//        switch (s) {
//            case '0' -> str = "";
//            case '1' -> str = "Ⅰ";
//            case '2' -> str = "Ⅱ";
//            case '3' -> str = "Ⅲ";
//            case '4' -> str = "Ⅳ";
//            case '5' -> str = "Ⅴ";
//            case '6' -> str = "Ⅵ";
//            case '7' -> str = "Ⅶ";
//            case '8' -> str = "Ⅷ";
//            case '9' -> str = "Ⅸ";
//        }

        //JDK12新特性
        String str = switch (s) {
            case '0' -> "";
            case '1' -> "Ⅰ";
            case '2' -> "Ⅱ";
            case '3' -> "Ⅲ";
            case '4' -> "Ⅳ";
            case '5' -> "Ⅴ";
            case '6' -> "Ⅵ";
            case '7' -> "Ⅶ";
            case '8' -> "Ⅷ";
            case '9' -> "Ⅸ";
            default -> "";
        };
        return str;
    }
}
