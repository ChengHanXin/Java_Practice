package com.aggregate.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MapFun {
    public static void main(String[] args) {
        // 创建Map集合
        Map<String, String> map = new HashMap<>();

        // 添加元素
        map.put("1", "aaa");
        map.put("2", "bbb");
        map.put("3", "ccc");

        lambda(map);


    }

    public static void keyFindValue(Map<String, String> map){
        // 使用键找值进行遍历
        // 获取所有的键，将其放在一个单列集合中
        Set<String> keySet = map.keySet();

        // 增强for遍历这个单列集合，获取每个键
        for (String key : keySet) {
            // 利用键，得到相应的值
            String value = map.get(key);
            System.out.println(key + ":" + value);
        }

        // 使用迭代器遍历
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = map.get(key);
            System.out.println(key + ":" + value);
        }

        // 使用lambda表达式遍历
        keySet.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                String value = map.get(s);
                System.out.println(s + ":" + value);
            }
        });
    }

    public static void entryObject(Map<String, String> map){
        // 通过键值对对象进行遍历

        // 通过entrySet方法获取所有的键值对对象，返回一个set集合
        Set<Map.Entry<String, String>> entrySet = map.entrySet();

        // 使用增强for遍历set，得到每一个键值对对象
        for (Map.Entry<String, String> entry : entrySet) {
            String key = entry.getKey();    // 得到该键值对对象的键
            String value = entry.getValue();    // 得到该键值对对象的值
            System.out.println(key + ":" + value);
        }

        // 使用迭代器遍历set，得到每一个键值对对象
        Iterator<Map.Entry<String, String>> it = entrySet.iterator();
        while (it.hasNext()){
            Map.Entry<String, String> entry = it.next();    // 获得当前键值对对象
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }

        // 使用lambda表达式遍历set
        entrySet.forEach(new Consumer<Map.Entry<String, String>>(){
            @Override
            public void accept(Map.Entry<String, String> stringStringEntry) {
                String key = stringStringEntry.getKey();
                String value = stringStringEntry.getValue();
                System.out.println(key + ":" + value);
            }
        });
    }

    public static void lambda(Map<String, String> map){
        // 底层调用forEeach方法进行遍历
        map.forEach(new BiConsumer<String, String>(){
            @Override
            public void accept(String key, String value) {
                System.out.println(key + ":" + value);
            }
        });
    }
}
