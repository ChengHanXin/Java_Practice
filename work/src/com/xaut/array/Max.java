package com.xaut.array;

public class Max {
    public static void main(String[] args) {
        /*需求：求数组中的最大值*/
        int[] array = new int[]{2, 3, -9, 10, 5};
        //定义最大值，用来存储数组中的最大值
        //最大值可以初始化为0吗？ [-3, -5, -9]，此时最大值是-3，但是会出输出最大值为0
        //所以最大值应该初始化为数组中的值！！！
        int max = array[0];
        //循环遍历数组，找出最大值
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("数组中的最大值为：" + max);
    }
}
