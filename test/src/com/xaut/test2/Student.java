package com.xaut.test2;

public class Student {

    protected String name;
    private void show(){
        System.out.println(name);
    }

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
