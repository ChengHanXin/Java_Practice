package com.reflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Prac {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 结合配置文件，动态的创建对象和调用方法
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\Users\\user\\Desktop\\java\\Practice\\work\\src\\com\\reflect\\prop.properties"));
        System.out.println(prop);

        // 获取需要创建的对象全类名 和 需要调用方法的名字
        String className = (String) prop.get("classname");
        String methodName = (String) prop.get("method");

        // 创建字节码对象
        Class c = Class.forName(className);
        // 获取构造方法
        Constructor constructorMethod = c.getDeclaredConstructor();
        // 使用构造方法创建对象
        constructorMethod.setAccessible(true);
        Object obj =constructorMethod.newInstance();

        // 获取对应的方法并执行
        c.getDeclaredMethod(methodName).invoke(obj);




    }
}
