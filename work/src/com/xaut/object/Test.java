package com.xaut.object;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("lihua");
        person.setAge(18);
        System.out.println(person.getAge());
        System.out.println(person.getName());

        Person person2 = new Person("xiaomei", 19);
        System.out.println(person2.getAge());
        System.out.println(person2.getName());

    }

}
