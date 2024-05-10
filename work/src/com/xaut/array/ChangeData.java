package com.xaut.array;

public class ChangeData {
    public static void main(String[] args) {
        /*需求：定义一个数组，存入1,2,3,4,5。按照要求交换索引对应的元素。
            交换前：1,2,3,4,5
            交换后：5,2,3,4,1*/
        int[] arr = new int[]{1, 2, 3, 4, 5};
        //定义两个标志，从头尾分别向中间靠拢，同时交换彼此之间的元素
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
