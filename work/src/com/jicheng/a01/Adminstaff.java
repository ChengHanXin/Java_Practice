package com.jicheng.a01;

public class Adminstaff extends Employe{

    public Adminstaff() {
    }

    public Adminstaff(String name, String id, String job) {
        super(name, id, job);
    }

    @Override
    public void job(){
        System.out.println("行政员工正在工作");
    }
}
