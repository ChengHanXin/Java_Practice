package com.jicheng.a01;

public class Buyer extends Adminstaff{

    public Buyer() {
    }

    public Buyer(String name, String id, String job) {
        super(name, id, job);
    }

    @Override
    public void job(){
        System.out.println(this.getName() + "正在采购");
    }
}
