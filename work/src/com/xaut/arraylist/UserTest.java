package com.xaut.arraylist;

import java.util.ArrayList;

public class UserTest {
    public static void main(String[] args) {
        /*需求：
        1，main方法中定义一个集合，存入三个用户对象。
           用户属性为：id，username，password
        2，要求：定义一个方法，根据id查找对应的学生信息。
           如果存在，返回索引
           如果不存在，返回-1
        3，要求：定义一个方法，根据id查找对应的学生信息。
            如果存在，返回true
            如果不存在，返回false*/

        ArrayList<User> users = new ArrayList<User>();
        User u1 = new User("001", "zhangsan", "123");
        User u2 = new User("002", "lisi", "456");
        User u3 = new User("003", "wangwu", "789");

        users.add(u1);
        users.add(u2);
        users.add(u3);

        int index = getIndex(users, "004");
        System.out.println(index);

        boolean flag = contains(users, "005");
        System.out.println(flag);

    }

    public static int getIndex(ArrayList<User> users, String id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public static boolean contains(ArrayList<User> users, String id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
