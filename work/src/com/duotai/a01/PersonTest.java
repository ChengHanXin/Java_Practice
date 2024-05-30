package com.duotai.a01;

public class PersonTest {
    public static void main(String[] args) {
        /*测试person类及其方法*/

        Person person = new Person("老王", 26);
        Dog dog = new Dog(2, "黑色");
        Cat cat = new Cat(3, "白色");

        person.keepPet(dog, "骨头");
        person.keepPet(cat, "鱼");
    }
}
