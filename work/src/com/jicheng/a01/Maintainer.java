package com.jicheng.a01;

public class Maintainer extends Adminstaff{

    public Maintainer() {
    }

    public Maintainer(String name, String id, String job) {
        super(name, id, job);
    }

    @Override
    public void job(){
        System.out.println(this.getName() + "正在维护工作");
    }
}
