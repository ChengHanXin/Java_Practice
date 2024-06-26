package com.xaut.api;

public class ObjectTest {
    public static void main(String[] args) {
        String str = "123";
        System.out.println(str);
//        str = change(str);  // 静态方法不能调用非静态方法
        System.out.println(change(str));
    }

    public static String change (String str) {
        str = "456";
        return str;
    }
}
