package com.reflect;

import java.lang.reflect.Field;

public class FieldsDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // 获取字节码对象
        Class c = Class.forName("com.reflect.Student");

        // 获取所有public成员变量
        Field[] fields1 = c.getFields();
        for (Field f : fields1) {
            System.out.println(f);
        }
        System.out.println("------------------------");

        // 获取所有成员变量
        Field[] fileds2 = c.getDeclaredFields();
        for (Field f : fileds2) {
            System.out.println(f.getName());
        }
        System.out.println("------------------------");

        // 获取单个成员变量
        // 获取public成员变量
        Field gender = c.getField("gender");
        System.out.println(gender);

        // 获取任意成员变量
        Field field = c.getDeclaredField("name");
        System.out.println(field);
        System.out.println("------------------------");

        // 操作获取到的成员变量
        Student stu = new Student("张三", 12, "男");
        // 获取对象该变量存储的值
        field.setAccessible(true);  // 将私有变量设置为可访问
        String res = (String) field.get(stu);
        System.out.println(res);
        // 修改该成员变量存储的值
        field.set(stu, "李四");
        System.out.println(stu);


    }
}
