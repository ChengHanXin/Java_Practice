package com.mutilthread.printnumber;

public class Test {
    /*需求：
    	同时开启两个线程，共同获取1-100之间的所有数字。
    	将输出所有的奇数。*/

    public static void main(String[] args) {
        OddNumber oddNumber1 = new OddNumber();
        OddNumber oddNumber2 = new OddNumber();

        oddNumber1.setName("线程1");
        oddNumber2.setName("线程2");

        oddNumber1.start();
        oddNumber2.start();
    }
}
