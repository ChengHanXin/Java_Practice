package com.jicheng.a02;

public class Cat extends Animal {
    public Cat() {
    }

    public Cat(int age, String color) {
        super(age, color);
    }

    @Override
    public void eat(String food){
        System.out.println("颜色为" + getColor() + "的" + getAge() + "岁的猫，在吃" + food);
    }

    public void catchMouse(){
        System.out.println("猫正在抓老鼠");
    }

}
