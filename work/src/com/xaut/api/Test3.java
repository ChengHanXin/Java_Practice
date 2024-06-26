package com.xaut.api;

public class Test3 {
    /*定义一个方法自己实现toBinaryString方法的效果，将一个十进制整数转成字符串表示的二进制*/
    public static void main(String[] args) {
        int number = 5;
        System.out.println(toBinaryString(number));
    }

    public static String toBinaryString(int n) {
        StringBuffer sb = new StringBuffer();
        while(n > 0){
            sb.append(n % 2);
            n /= 2;
        }
        return sb.reverse().toString();
    }
}
