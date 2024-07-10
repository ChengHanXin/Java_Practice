package com.mutilthread.cookfoodzuse;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook extends Thread {

    ArrayBlockingQueue<String> queue;

    public Cook(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            // 不断的从阻塞队列中获取数据
            try {
                queue.take();      // take方法里面自动执行了加锁和解锁
                System.out.println("吃货吃了一个食物");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
