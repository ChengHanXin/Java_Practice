package com.aggregate.list;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        // 调用remove方法进行删除, 此时会调用E remove(int index)方法。因为参数类型一致。
        list.remove(1);
    }
}
