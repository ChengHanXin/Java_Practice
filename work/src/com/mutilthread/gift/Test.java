package com.mutilthread.gift;

public class Test {
    /*需求：
        有100份礼品,两人同时发送，当剩下的礼品小于10份的时候则不再送出。
        利用多线程模拟该过程并将线程的名字和礼物的剩余数量打印出来.*/
    public static void main(String[] args) {
        SendGift sendGift1 = new SendGift();
        SendGift sendGift2 = new SendGift();

        sendGift1.setName("线程一");
        sendGift2.setName("线程二");

        sendGift1.start();
        sendGift2.start();

    }

}
