package com.aggregate.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntFunction;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        String[] arr = list.stream().toArray(new IntFunction<String []>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });

//        String[] arr2 = list.stream().toArray(value -> new String[value]);

        String[] arr2 = list.stream().toArray(String[]::new);

        System.out.println(Arrays.toString(arr2));
    }
}
