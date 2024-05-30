package com.jicheng.a01;

public class Teacher extends Employe{
    //由于构造方法不能继承，所以需要

    public Teacher() {
    }

    public Teacher(String name, String id, String job) {
        super(name, id, job);
    }

    //重写job方法
    @Override
    public void job(){
        System.out.println("老师正在上课");
    }
}
