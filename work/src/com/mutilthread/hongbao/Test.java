package com.mutilthread.hongbao;

public class Test {
    /*需求：
       抢红包也用到了多线程。
       假设：100块，分成了3个包，现在有5个人去抢。
       其中，红包是共享数据。
       5个人是5条线程。
       打印结果如下：
             XXX抢到了XXX元
             XXX抢到了XXX元
             XXX抢到了XXX元
             XXX没抢到
             XXX没抢到*/
    public static void main(String[] args) {

        QiangHongBao q1 = new QiangHongBao("小美");
        QiangHongBao q2 = new QiangHongBao("小明");
        QiangHongBao q3 = new QiangHongBao("小智");
        QiangHongBao q4 = new QiangHongBao("小飞");
        QiangHongBao q5 = new QiangHongBao("小李");

        q1.start();
        q2.start();
        q3.start();
        q4.start();
        q5.start();
    }
}