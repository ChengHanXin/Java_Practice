package com.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MethodsDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 获取字节码对象
        Class c = Class.forName("com.reflect.Student");

        // 获取所有public成员方法（包括父类的public方法）
        Method[] methods1 = c.getMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }
        System.out.println("------------------------------");

        // 获取所有的成员方法（不包括父类，只获取本类）
        Method[] methods2  = c.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println(method);
        }
        System.out.println("------------------------------");

        // 获取指定的public成员方法
        Method methods3  = c.getMethod("sleep");
        System.out.println(methods3);
        System.out.println("------------------------------");

        // 获取指定的所有成员方法
        Method methods4 = c.getDeclaredMethod("eat", String.class);
        System.out.println(methods4);

        // 操作获取到的成员方法
        String name = methods4.getName();   // 获取方法名
        System.out.println(name);

        // 获取方法参数
        Parameter[] parameters = methods4.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }

        // 运行方法
        methods4.setAccessible(true);
        Student student = new Student();
        String res = (String) methods4.invoke(student, "面");
        System.out.println(res);


    }
}
