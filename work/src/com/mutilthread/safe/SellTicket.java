package com.mutilthread.safe;

public class SellTicket extends Thread {
    // 表示这个类所有的对象，都共享该数据
    static int tickets = 0;
    // 锁对象，一定要是唯一的
    static Object obj = new Object();

    public SellTicket(String str) {
        super(str);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (SellTicket.class) { // 对可能有安全问题的代码加锁,多个线程必须使用同一把锁
                //t1进来后，就会把这段代码给锁起来
                if (tickets < 500000) {
                    //窗口1正在出售第100张票
                    tickets++; //tickets = 99;
                    System.out.println(getName() + "正在出售第" + tickets + "张票");
                } else {
                    break;
                }
            }
            //t1出来了，这段代码的锁就被释放了
        }
    }
}

