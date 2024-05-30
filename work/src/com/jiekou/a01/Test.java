package com.jiekou.a01;

/*使用抽象类和接口完成
 * 青蛙frog  属性：名字，年龄   行为：吃虫子，蛙泳
 * 狗dog     属性：名字，年龄   行为：吃骨头，狗刨
 * 山羊sheep  属性：名字，年龄   行为：吃草
 * 由于山羊不会游泳，所以该行为不能抽取到父类中，使用接口统一游泳行为规则*/

public class Test {
    public static void main(String[] args) {
        Frog f = new Frog("小青", 3);
        System.out.println(f.getName() + "," + f.getAge());
        f.eat();
        f.swim();

        Sheep s = new Sheep("小白", 2);
        System.out.println(s.getName() + "," + s.getAge());
        s.eat();

    }
}
