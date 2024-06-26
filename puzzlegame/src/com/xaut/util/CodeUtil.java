package com.xaut.util;

import java.util.Random;

public class CodeUtil {
    public static String getCode(){
        /*需求：
                定义方法实现随机产生一个5位的验证码
            验证码格式：
                长度为5
                包含四个英文字母（大小写均可）和一个数字，它们之间的位置随机*/

        String verificationCode = "";

        char[] letter = new char[52];
            for (int i = 0; i < letter.length; i++) {
            if (i <= 25) {
                letter[i] = (char) ('a' + i);
            } else {
                letter[i] = (char) ('A' + i - 26);
            }
        }

        Random random = new Random();
            for (int i = 0; i < 4; i++) {
            int point = random.nextInt(letter.length);
            verificationCode += letter[point];
        }
        int number = random.nextInt(9) + 1;
        verificationCode += number;

        // 随机分配位置
        char[] chars = verificationCode.toCharArray();
        int index = random.nextInt(chars.length - 1);
        char temp = chars[index];
        chars[index] = chars[chars.length - 1];
        chars[chars.length - 1] = temp;
        String res = new String(chars);

        return res;
    }
}
