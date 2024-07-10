package com.mutilthread.gift;

public class SendGift extends Thread {

    // 定义礼物数量
    static int giftNum = 100;

    @Override
    public void run() {
        while(true) {
            // 使用该类的字节码对象来加锁
            synchronized (SendGift.class) {
                if (giftNum < 10) {
                    break;
                } else {
                    giftNum--;
                    System.out.println(getName() + "送出一份礼物，还剩" + giftNum + "个礼物");
                }
            }
        }
    }
}
