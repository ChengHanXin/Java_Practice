package com.reflect;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // 获取字节码文件对象
        Class c = Class.forName("com.reflect.Student");

        // 获取构造方法
        // 获取所有public修饰的构造方法
        Constructor[] constructors1 = c.getConstructors();
        for (Constructor constructor : constructors1) {
            System.out.println(constructor);
        }

        System.out.println("--------------------------");

        // 获取所有构造方法，包括private、protected的
        Constructor[] constructors2 = c.getDeclaredConstructors();
        for (Constructor constructor : constructors2) {
            System.out.println(constructor);
        }

        System.out.println("--------------------------");

        // 获取指定的构造(public修饰的)
        Constructor con1  = c.getConstructor();
        System.out.println(con1);

        Constructor con2  = c.getConstructor(String.class, int.class);
        System.out.println(con2);

        System.out.println("--------------------------");

        // 获取指定的构造(所有都可以)
        Constructor con3  = c.getDeclaredConstructor(String.class);
        System.out.println(con3);

        // 使用得到的构造方法对象来创建对象
        // 由于con3获取的为私有构造方法，所以在使用它创建对象时，需要设定为可访问
        con3.setAccessible(true);   // 暴力反射
        Student stu = (Student) con3.newInstance("张三");
        System.out.println(stu.toString());



    }
}
