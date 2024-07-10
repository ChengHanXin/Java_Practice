package com.mutilthread.cookfood;

public class Table {
    // 表示共享的数据区域

    public static int count = 10;   // 表示一共吃10碗

    public static Object lock = new Object();   // 共享的锁对象

    // 表示共享区域的状态
    // 0-->桌子上没有食物      1-->桌子上有食物
    public static int flage = 1;

}
