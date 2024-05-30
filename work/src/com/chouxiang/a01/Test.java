package com.chouxiang.a01;

/*编写带有抽象类的标准javabean类
* 青蛙frog  属性：名字，年龄   行为：吃虫子，喝水
* 狗dog     属性：名字，年龄   行为：吃骨头，喝水
* 山羊sheep  属性：名字，年龄   行为：吃草，喝水
* 由于不同动物的吃行为不统一，所以需要在父类动物中，编写抽象eat方法  */

public class Test {
    public static void main(String[] args) {
        Frog f = new Frog("小绿", 5);
        System.out.println(f.getName() + "  " + f.getAge());
        f.drink();
        f.eat();
    }
}
