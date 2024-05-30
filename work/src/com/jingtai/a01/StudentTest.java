package com.jingtai.a01;

import java.util.ArrayList;

public class StudentTest {
    /*创建一个list包含三个学生对象，学生属性有name、age和gender
    * 创建一个工具类，实现返回list中年龄最大值*/

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        Student s1 = new Student("张三", 23, "男");
        Student s2 = new Student("李四", 24, "男");
        Student s3 = new Student("王五", 25, "男");

        list.add(s1);
        list.add(s2);
        list.add(s3);

        int maxAge = StudentUtil.getMaxAge(list);
        System.out.println(maxAge);
    }

}
