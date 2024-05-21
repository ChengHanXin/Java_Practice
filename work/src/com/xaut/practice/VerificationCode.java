package com.xaut.practice;

import java.util.Random;

public class VerificationCode {
    public static void main(String[] args) {
        /*需求：
	        定义方法实现随机产生一个5位的验证码
        验证码格式：
	        长度为5
	        前四位是大写字母或者小写字母
	        最后一位是数字*/

        String res = "";   //保存生成的验证码

        // 由于a-z和A-Z之间的ASCAII码不连续，所以不能直接随机抽取
        char[] letter = new char[52];
        for (int i = 0; i < letter.length; i++) {
            //前26个保存小写字母，后26个保存大写字母
            if (i <= 25) {
                letter[i] = (char) ('a' + i);
            } else{
                //letter[i] = (char) ('A' + i);  此时i已经超过26了
                letter[i] = (char) ('A' + i - 26);
            }
        }

        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int point = random.nextInt(52);
            res += letter[point];
        }

        int number = random.nextInt(10);
        res += number;
        System.out.println(res);
    }
}
