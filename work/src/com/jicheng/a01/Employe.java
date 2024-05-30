package com.jicheng.a01;

public class Employe {
    private String name;
    private String id;
    private String job;

    public Employe() {
    }

    public Employe(String name, String id, String job) {
        this.name = name;
        this.id = id;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void job(){
        System.out.println("员工正在工作");
    }
}
