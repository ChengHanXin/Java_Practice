package com.mutilthread.printnumber;

public class OddNumber extends Thread {

    static int i = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (OddNumber.class) {
                if (i >= 10000) {
                    break;
                } else {
                    if (i % 2 == 1) {
                        System.out.println(getName() + " : " + i);
                    }
                    i++;
                }
            }
        }
    }
}
