package com.jicheng.a01;

public class Tutor extends Teacher {

    public Tutor() {
    }

    public Tutor(String name, String id, String job) {
        super(name, id, job);
    }

    @Override
    public void job(){
        System.out.println(this.getName() + "助教老师正在帮助同学");
    }
}
