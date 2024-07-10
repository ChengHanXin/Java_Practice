package com.aggregate.map;

import java.lang.reflect.Array;
import java.util.*;

public class Travel {
    public static void main(String[] args) {
        /*  某班级80名学生，去秋游，一共四个景点ABCD，每个学生只能选择一个景点，
        统计想去哪个景点的人数最多*/

        String[] arr = {"A", "B", "C", "D"};    // 景点name
        ArrayList<String> list = new ArrayList<>();     // 每个学生投票结果
        //随机投票过程
        Random r = new Random();
        for (int i = 0; i < 80; i++) {
            int index = r.nextInt(arr.length);
            list.add(arr[index]);
        }

        // 统计投票结果。如果事先不知道有几个结果，还要统计结果最大值，可以使用map
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(list.get(i))){
                map.put(list.get(i), map.get(list.get(i)) + 1);
            } else {
                map.put(list.get(i), 1);
            }
        }
        System.out.println(map);

        int max = 0;
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        System.out.println(max);

        // 打印出集合中与最大值相同的键
        for (Map.Entry<String, Integer> entry : entrySet) {
            if (entry.getValue() == max) {
                System.out.println(entry.getKey());
            }
        }


//        System.out.println(list);
    }
}
