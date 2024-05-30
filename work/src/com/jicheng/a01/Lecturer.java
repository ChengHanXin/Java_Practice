package com.jicheng.a01;

public class Lecturer extends Teacher{
    public Lecturer() {
    }

    public Lecturer(String name, String id, String job) {
        super(name, id, job);
    }

    @Override
    public void job(){
        System.out.println(this.getName() + "老师正在上课" );
    }
}
