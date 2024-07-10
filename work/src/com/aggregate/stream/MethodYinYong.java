package com.aggregate.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;

public class MethodYinYong {
    public static void main(String[] args) {
        /*创建集合添加学生对象，学生对象属性：name，age
        * 把姓名和年龄拼接成：张三-23的字符串，并放到数组中
        * 使用方法引用完成*/

        // 创建集合存放学生对象
        ArrayList<Student> students = new ArrayList<>();

        Student s1 = new Student("张三", 23);
        Student s2 = new Student("李四", 24);
        Student s3 = new Student("王五", 25);

        Collections.addAll(students, s1, s2, s3);

        String[] arr = students.stream().map(new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return student.getName() + "-" + student.getAge();
            }
        }).toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });

        String[] arr2 = students.stream().map(Student::changeFormat).toArray(String[]::new);

        System.out.println(Arrays.toString(arr2));

    }
}
