package com.aggregate.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class BianLi {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("AAA");
        list.add("BBB");

        // 使用列表迭代器对象进行遍历
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            // 在列表迭代器对象中，除了remvoe方法外，还有一个add方法
            if (str.equals("BBB")) {
//                iterator.remove();  删除当前元素，不接受参数
                iterator.add("CCC");
            }
            System.out.println(str);
        }

        // 使用普通for遍历
        for (int i = 0; i < list.size(); i++) {
            if (i == 0){
                list.set(i, "DDD");
            }
            System.out.println(list.get(i));
        }

        System.out.println(list);
    }
}
