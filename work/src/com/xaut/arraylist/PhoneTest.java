package com.xaut.arraylist;

import java.util.ArrayList;

public class PhoneTest {
    public static void main(String[] args) {
        /*需求：
        1，main方法中定义一个集合，存入三个手机对象。
           手机属性为：brand，money，
        2，要求：定义一个方法，返回所有金额小于3000的手机*/

        ArrayList<Phone> phones = new ArrayList<>();
        Phone p1 = new Phone("小米", 2999);
        Phone p2 = new Phone("荣耀", 2599);
        Phone p3 = new Phone("华为", 5999);
        phones.add(p1);
        phones.add(p2);
        phones.add(p3);

        phones.iterator();
        
        ArrayList<Phone> res = getPhones(phones);

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).getBrand() + res.get(i).getMoney());
        }


    }

    public static ArrayList<Phone> getPhones(ArrayList<Phone> phones) {
        ArrayList<Phone> res = new ArrayList<>();
        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).getMoney() < 3000){
                res.add(phones.get(i));
            }
        }
        return res;
    }
}
