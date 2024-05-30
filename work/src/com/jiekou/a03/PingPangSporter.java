package com.jiekou.a03;

public class PingPangSporter extends Sporter implements SpeakEnglish {

    public PingPangSporter() {
    }

    public PingPangSporter(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println("乒乓球运动员在说英语");
    }

    @Override
    public void learn() {
        System.out.println("乒乓球运动员在学习打乒乓球");
    }
}
