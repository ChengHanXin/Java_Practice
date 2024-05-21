package com.xaut.object;

public class Person {
    private String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        if (age > 0){
            this.age = age;
        }else {
            System.out.println("非法年龄值");
        }
    }
    public int getAge(){
        return this.age;
    }
}
