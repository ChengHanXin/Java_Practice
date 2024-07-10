package com.mutilthread.cookfood;

public class Cook extends Thread {

    /*
    *  1. 判断有没有到终止状态
    *  2. 判断桌子状态，如果有食物，则等待；
    *  3. 如果没有食物，则制作食物，更新桌子状态，唤醒eat进程
    *
    *
    * */

    @Override
    public void run() {
        while (true) {
            synchronized (Table.lock) {
                if(Table.count == 0){
                    break;
                } else{
                    if(Table.flage == 1){
                        // 桌子有食物，等待
                        try {
                            Table.lock.wait();   // 此时会释放掉以获得到的锁，以便让eat进程去执行
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else{
                        // 如果桌子没有食物，则制作食物，唤醒eat开吃
                        System.out.println(getName() + "正在制作食物");
                        Table.flage = 1;
                        Table.lock.notifyAll();
                    }
                }
            }
        }
    }
}
