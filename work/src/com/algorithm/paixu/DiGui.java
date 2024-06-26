package com.algorithm.paixu;

public class DiGui {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 5, 2, 6, 9};
        qucikSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void qucikSort(int[] arr, int i ,int j) {
        int start = i;
        int end = j;

        // 子数组长度为1时，停止递归
        if (start >= end) {
            return;
        }

        int baseNumber = arr[start];

        while (start != end) {
            //从后往前找到比baseNumber小的元素索引end
            while (true){
                if (end <= start || arr[end] < baseNumber){
                    break;
                }
                end--;
            }

            //从前往后找到比baseNumber大的元素索引start
            while (true){
                if (end <= start || arr[start] > baseNumber){
                    break;
                }
                start++;
            }

            //交换找到的两个元素
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

        //将基准数跟指针指向位置的数字交换位置
        int temp = arr[start];
        arr[start] = baseNumber;
        arr[i] = temp;

        //左右递归执行子序列排序
        qucikSort(arr, i, start - 1);
        qucikSort(arr, start + 1, j);
    }
}
