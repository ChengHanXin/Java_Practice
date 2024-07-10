package com.mutilthread.choujiang;

import java.util.ArrayList;
import java.util.Collections;

public class ChouJiang extends Thread {

    ArrayList<Integer> list = new ArrayList<>();

    public ChouJiang(String name, ArrayList<Integer> list) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        while(true){
            synchronized (ChouJiang.class) {
                if (list.size() == 0){
                    break;
                } else{
                    // 打乱数组，达到随机抽奖的效果
                    Collections.shuffle(list);
                    int money = list.remove(0);
                    System.out.println(getName() + "又产生了一个" + money + "元大奖");
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
