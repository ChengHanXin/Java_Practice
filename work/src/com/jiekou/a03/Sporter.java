package com.jiekou.a03;

public abstract class Sporter extends Person{
    public Sporter() {
    }

    public Sporter(String name, int age) {
        super(name, age);
    }

    public abstract void learn();
}
