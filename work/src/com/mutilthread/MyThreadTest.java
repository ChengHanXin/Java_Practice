package com.mutilthread;

public class MyThreadTest {
    public static void main(String[] args) {
        /*  定义一个类继承Thread类
            在该类中重写run()方法
            创建该类的对象
            启动线程*/

        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.setName("线程1");    // 给线程命名，该方法定义在Thread类中
        myThread2.setName("线程2");

        myThread1.start();
        myThread2.start();
    }
}
