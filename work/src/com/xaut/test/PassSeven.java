package com.xaut.test;

public class PassSeven {
    public static void main(String[] args) {
        /*
            需求：打印出1-100的所有数字，但遇到包含7或7的倍数时，打印过。
        */

        for(int i = 1; i <= 100; i++) {
            // 个位是7；十位是7；7的倍数
            if(i % 10 == 7 || i / 10 % 10 == 7 || i % 7 == 0){
                System.out.println("过");
                continue;
            }
            System.out.println(i);
        }
    }
}
