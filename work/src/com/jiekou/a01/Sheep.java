package com.jiekou.a01;

public class Sheep extends Animal {

    public Sheep() {
    }

    public Sheep(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("山羊在吃草");
    }
}
