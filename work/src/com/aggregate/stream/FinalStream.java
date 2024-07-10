package com.aggregate.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FinalStream {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list,"张无忌-男-15", "周芷若-女-14", "赵敏-女-13", "张强-男-20",
                "张三丰-男-100","张零山-男-40", "张良-男-35", "王二麻子-男-37", "谢广坤-男-41");
        collectionToList(list);
        collectionToSet(list);
        collectionToMap(list);
    }

    public static void collectionToList(ArrayList<String> list){
        // 将所有的男性收集到一个List集合中
        List<String> newList =  list.stream().filter(s -> s.split("-")[1].equals("男")).
                collect(Collectors.toList());
        System.out.println(newList);
    }

    public static void collectionToSet(ArrayList<String> list){
        // 建议使用确定的变量来调用方法，防止空指针异常
        // 使用toSet来收集，可以自动剔除重复的数据
        Set<String> newSet = list.stream().filter(s -> "男".equals(s.split("-")[1])).
                collect(Collectors.toSet());
        System.out.println(newSet);
    }

    public static void collectionToMap(ArrayList<String> list){
        // 将所有男生收集到Map集合中，姓名为键，年龄为值
        Map<String, Integer> map = list.stream().filter(s -> "男".equals(s.split("-")[1])).
                /*
                *  需要指定两个参数：键生成的规则、值生成的规则
                *  参数一：
                *       Function泛型一：表示流中每一个数据的类型
                *               泛型二：表示Map集合中键的数据类型
                *        方法apply形参：表示流中每一个数据
                *               方法体：生成键的代码
                *               返回值：已经生成的键
                *   参数二：
                *       Function泛型一：表示流中每一个数据的类型
                *               泛型二：表示Map集合中值的数据类型
                *        方法apply形参：表示流中每一个数据
                *               方法体：生成值的代码
                *               返回值：已经生成的值
                *
                * */
                collect(Collectors.toMap(new Function<String, String>() {
                                             @Override
                                             public String apply(String s) {
                                                 return s.split("-")[0];
                                             }
                                         } ,

                        new Function<String, Integer>() {
                            @Override
                            public Integer apply(String s) {
                                return Integer.parseInt(s.split("-")[2]);
                            }
                        }));

                Map<String, Integer> newMap = list.stream().filter(s -> "男".equals(s.split("-")[1])).
                        collect(Collectors.toMap(s -> s.split("-")[0], s -> Integer.parseInt(s.split("-")[2])));

                System.out.println(newMap);
    }


}
