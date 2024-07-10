package com.mutilthread.choujiang3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class ChouJiang implements Callable<Integer> {

    ArrayList<Integer> list = new ArrayList<>();

    public ChouJiang(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {
        // 用来存储每个进程的抽奖结果
        ArrayList<Integer> boxList = new ArrayList<>();

        while(true){
            synchronized (ChouJiang.class) {
                if (list.size() == 0){
                    System.out.println("在此次抽奖过程中，" + Thread.currentThread().getName() + "总共产生了" + boxList.size() + "个奖项。 分别为：" + boxList);
                    break;
                } else{
                    // 打乱数组，达到随机抽奖的效果
                    Collections.shuffle(list);
                    int money = list.remove(0);
                    boxList.add(money);
//                    System.out.println(getName() + "又产生了一个" + money + "元大奖");
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (boxList.size() == 0){
            return null;
        }

        return Collections.max(boxList);
    }
}
