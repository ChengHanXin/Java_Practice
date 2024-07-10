package com.mutilthread.cookfood;

public class Eat extends Thread {

    /*
    *  1. 判断是否到达终止条件
    *  2. 判断桌子上是否有食物
    *  3. 如果有，则直接吃，修改桌子状态，唤醒cook制作食物
    *  4. 如果没有，则等待
    *
    * */

    @Override
    public void run() {
        while (true) {
            synchronized (Table.lock) {
                if (Table.count == 0){
                    break;
                } else{
                    if (Table.flage == 1){
                        Table.count--;
                        System.out.println(getName() + "正在吃饭，还能吃" + Table.count + "碗");
                        Table.flage = 0;
                        Table.lock.notifyAll();     // 不会释放掉当前锁，要等到同步块执行完后才会释放
                    } else{
                        try {
                            Table.lock.wait();      // 释放掉当前的锁，以便让cook进程执行，去制作食物
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            }
        }
    }

}
