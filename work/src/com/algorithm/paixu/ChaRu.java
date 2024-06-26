package com.algorithm.paixu;

public class ChaRu {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 6, 1};

        //1.找到无序开始的索引
        int startIndex = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]){
                startIndex = i + 1;
                break;
            }
        }

        //2.将无序的元素插入到前面有序的元素中
        for (int i = startIndex; i < arr.length; i++) {
            //用于记录待插入元素的索引
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]){
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
