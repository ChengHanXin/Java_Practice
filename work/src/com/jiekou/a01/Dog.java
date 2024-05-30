package com.jiekou.a01;

public class Dog extends Animal implements Swim{
    @Override
    public void eat() {
        System.out.println("狗在吃骨头");
    }

    @Override
    public void swim() {
        System.out.println("狗在狗刨");
    }
}
