package com.xaut.test;

public class SelfAdd {
    public static void main(String[] args) {
        int a = 1;
        int b = a++;	// b=1，此时先赋值，再自增
        int c = ++a;	// c=3，此时先自增，再赋值
        System.out.println(b);
        System.out.println(c);
    }
}
