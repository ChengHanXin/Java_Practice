package com.duotai.a01;

public class Person {

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public void keepPet(Dog dog, String food) {
//        //这种方式不对，因为现在是狗在吃东西，是对狗的描述，应该将其封装在狗类中，然后在这里调用相应的方法
//        //System.out.println("颜色为" + dog.getColor() + "的" + dog.getAge() + "岁的狗，在吃" + food);
//        System.out.println("年龄为" + age + "岁的" + name + "养了一只" + dog.getColor() + "颜色的" + dog.getAge() + "岁的狗");
//        dog.eat(food);
//    }
//
//    public void keepPet(Cat cat, String food) {
//        //同理
//        //System.out.println("颜色为" + cat.getColor() + "的" + cat.getAge() + "岁的猫，在吃" + food);
//        System.out.println("年龄为" + age + "岁的" + name + "养了一只" + cat.getColor() + "颜色的" + cat.getAge() + "岁的猫");
//        cat.eat(food);
//    }

    //1.Dog和Cat都是Animal的子类，以上案例中针对不同的动物，定义了不同的keepPet方法，过于繁琐，能否简化，并体会简化后的好处？
    //2.Dog和Cat虽然都是Animal的子类，但是都有其特有方法，能否想办法在keepPet中调用特有方法？

    //使用多态特性来简化
    public void keepPet(Animal animal, String food){
        if (animal instanceof Cat c) {
            System.out.println("年龄为" + age + "岁的" + name + "养了一只" + animal.getColor() + "颜色的" + animal.getAge() + "岁的猫");
            c.eat(food);
            c.catchMouse();
        } else if (animal instanceof Dog d) {
            System.out.println("年龄为" + age + "岁的" + name + "养了一只" + animal.getColor() + "颜色的" + animal.getAge() + "岁的狗");
            d.eat(food);
            d.lookHome();
        }
    }
}
