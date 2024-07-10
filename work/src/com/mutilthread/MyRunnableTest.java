package com.mutilthread;

public class MyRunnableTest {
    public static void main(String[] args) {
        /* 定义一个类MyRunnable实现Runnable接口
           在MyRunnable类中重写run()方法
           创建MyRunnable类的对象
           创建Thread类的对象，把MyRunnable对象作为构造方法的参数
           启动线程
        */

        MyRunnable myRunnable = new MyRunnable();

        Thread t1 = new Thread(myRunnable);    // 可以理解为将这个任务交给线程
        Thread t2 = new Thread(myRunnable);

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        t2.start();
    }
}
