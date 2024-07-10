package com.reflect;

public class Student {
    private String name;
    private int age;
    public String gender;

    public Student() {}

    protected Student(int age){
        this.age = age;
    }

    private Student(String name){
        this.name = name;
    }

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public void sleep(){
        System.out.println("睡了一会");
    }

    private String eat(String food){
        System.out.println("我吃了一个" + food);
        return "吃饱了";
    }
}
