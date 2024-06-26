package com.aggregate.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class BianLi {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");

        //迭代器遍历
        //获取迭代器对象
        Iterator<String> it = list.iterator();
        //使用迭代器进行集合遍历
        while (it.hasNext()){
            // 获取当前元素，并移动指针到下一个位置
            String str = it.next();
            if (str.equals("A")){
                it.remove();
            }
            System.out.println(str);
        }

        // 增强for遍历
        for (String str : list){
            System.out.println(str);
        }

        // forEach方法遍历
        list.forEach(new Consumer<String>() {
            @Override
            // 这个函数代表对获取的每个元素进行的操作，都可以写在这个方法里面
            public void accept(String s) {
                System.out.println(s);
            }
        });
        // 使用Lambda表达式进行简化
        list.forEach((String s) -> System.out.println(s));

    }
}
