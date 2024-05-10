package com.xaut.array;

import java.util.Random;

public class TongJiGeShu {
    public static void main(String[] args) {
        /*需求：生成10个1~100之间的随机数存入数组。
            1）求出所有数据的和
            2）求所有数据的平均数
            3）统计有多少个数据比平均值小*/
        //使用动态初始化方式，定义一个数组
        int[] array = new int[10];
        //将生成的随机数存入数组中
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(100) + 1;
        }
        //求所有数据的和
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        //求所有数据的平均值
        int average = sum / array.length;
        System.out.println("数组平均值为：" + average);
        //统计比平均值小的数据个数
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < average) {
                count++;
            }
        }
        System.out.println("数组中比平均值小的元素个数为：" + count);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
