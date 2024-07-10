package com.mutilthread.cookfoodzuse;

import java.util.concurrent.ArrayBlockingQueue;

public class Test {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        Cook cook = new Cook(queue);

        Eat eat = new Eat(queue);

        cook.start();
        eat.start();
    }


}
