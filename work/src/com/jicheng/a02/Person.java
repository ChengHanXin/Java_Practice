package com.jicheng.a02;

public class Person {

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void keepDog(Dog dog, String food) {
        //这种方式不对，因为现在是狗在吃东西，是对狗的描述，应该将其封装在狗类中，然后在这里调用相应的方法
        //System.out.println("颜色为" + dog.getColor() + "的" + dog.getAge() + "岁的狗，在吃" + food);
        System.out.println("年龄为" + age + "岁的" + name + "养了一只" + dog.getColor() + "颜色的" + dog.getAge() + "岁的狗");
        dog.eat(food);
    }

    public void keepCat(Cat cat, String food) {
        //同理
        //System.out.println("颜色为" + cat.getColor() + "的" + cat.getAge() + "岁的猫，在吃" + food);
        System.out.println("年龄为" + age + "岁的" + name + "养了一只" + cat.getColor() + "颜色的" + cat.getAge() + "岁的猫");
        cat.eat(food);
    }
}
