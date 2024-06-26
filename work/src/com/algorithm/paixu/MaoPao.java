package com.algorithm.paixu;

public class MaoPao {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 4};

        //升序排列
        //进行arr.leangth-1次遍历，找到每一次的最大值，往后放
        for (int i = 0; i < arr.length - 1; i++) {
            //每一个子循环，将当前待排序范围的最大值放到其对应的最右边
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
