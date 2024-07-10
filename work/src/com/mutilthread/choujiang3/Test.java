package com.mutilthread.choujiang3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    /*需求：
        在上一题基础上继续完成如下需求：
            在此次抽奖过程中，抽奖箱1总共产生了6个奖项，分别为：10,20,100,500,2,300
            最高奖项为300元，总计额为932元
            在此次抽奖过程中，抽奖箱2总共产生了6个奖项，分别为：5,50,200,800,80,700
            最高奖项为800元，总计额为1835元
            在此次抽奖过程中,抽奖箱2中产生了最大奖项,该奖项金额为800元*/

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);

        // 创建多线程运行的参数对象
        ChouJiang c = new ChouJiang(list);

        // 创建两个进程对应的结果管理对象
        FutureTask<Integer> f1 = new FutureTask<>(c);
        FutureTask<Integer> f2 = new FutureTask<>(c);

        // 创建线程对象
        Thread t1 = new Thread(f1);
        Thread t2 = new Thread(f2);

        t1.setName("抽奖箱1");
        t2.setName("抽奖箱2");

        t1.start();
        t2.start();

        // 获取结果
        int r1 = f1.get();
        int r2 = f2.get();

        int res = r1 > r2 ? r1 : r2;

        System.out.println(res);


    }
}
