package com.mutilthread.choujiang2;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    /*需求：
        需求：
        	在上一题基础上继续完成如下需求：
            每次抽的过程中，不打印，抽完时一次性打印(随机)
            在此次抽奖过程中，抽奖箱1总共产生了6个奖项。
                     分别为：10,20,100,500,2,300最高奖项为300元，总计额为932元
            在此次抽奖过程中，抽奖箱2总共产生了6个奖项。
                     分别为：5,50,200,800,80,700最高奖项为800元，总计额为1835元
	 		  	 .....*/

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);

        ChouJiang c1 = new ChouJiang("抽奖箱1", list);
        ChouJiang c2 = new ChouJiang("抽奖箱2", list);

        c1.start();
        c2.start();

    }
}
