package com.mutilthread;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Thread t = Thread.currentThread();  // 获取当前线程
            String name = t.getName();     // 获取当前线程名字
            System.out.println(name + "hello world");
        }
    }
}
