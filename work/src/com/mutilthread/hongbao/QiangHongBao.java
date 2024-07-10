package com.mutilthread.hongbao;

import java.util.Random;

public class QiangHongBao extends Thread {

    static double money = 100;      // 红包总金额
    static int count = 3;       // 红包总个数

    static final double MIN_MONEY = 0.01;   // 红包最小金额为一分

    private String name;

    public QiangHongBao(String name) {
        super(name);
//        this.name = name;
    }

    @Override
    public void run() {
        synchronized (QiangHongBao.class) {
            if (count == 0){
                System.out.println(getName() + "没有抢到红包");
            } else{
                double price = 0;   //表示抽中的金额
                if (count == 1){
                    // 如果此时只剩一个红包，就不再随机金额
                    price = money;
                } else{
                    Random random = new Random();
                    double bounder = money - (count - 1) * MIN_MONEY;
                    price = random.nextDouble(bounder);
                    if (price < MIN_MONEY){
                        price = MIN_MONEY;
                    }
                }

                count--;
                money -= price;
                System.out.println(getName() + "抢到了" + price + "元");
            }

        }
    }

}
