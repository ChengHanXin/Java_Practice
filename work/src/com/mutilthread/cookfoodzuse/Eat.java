package com.mutilthread.cookfoodzuse;

import java.util.concurrent.ArrayBlockingQueue;

public class Eat extends Thread {

    ArrayBlockingQueue<String> queue;

    public Eat(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // 不断的往阻塞队列中添加数据
                queue.put("食物");    // put方法里面自动执行了加锁和解锁过程
                System.out.println("厨师制作了一份食物");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
