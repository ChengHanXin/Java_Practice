package com.xaut.test;

public interface Inter {

    public default void show(){
        System.out.println("Hello World");
    }
}
