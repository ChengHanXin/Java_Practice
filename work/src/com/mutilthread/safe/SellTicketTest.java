package com.mutilthread.safe;

public class SellTicketTest {
    public static void main(String[] args) {
        //创建SellTicket类的对象
        SellTicket st1 = new SellTicket("窗口1");
        SellTicket st2 = new SellTicket("窗口2");
        SellTicket st3 = new SellTicket("窗口3");

        //启动线程
        st1.start();
        st2.start();
        st3.start();
    }
}
