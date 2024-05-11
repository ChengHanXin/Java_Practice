package com.xaut.method;

public class CopyLength {
    public static void main(String[] args) {
        /*需求：
            定义一个方法copyOf(int[] arr, int newLength)
        功能：
            将数组arr中的newLength个元素拷贝到新数组中，并将新数组返回，从索引为0开始*/
        int[] arr = {1, 2, 3, 4, 5};
        int[] newArr = copyOf(arr, 2);
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }

    }

    public static int[] copyOf(int[] arr, int newLength) {
        if (newLength > arr.length) {
            int[] newArr = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            return newArr;
        }else{
            int[] newArr = new int[newLength];
            for (int i = 0; i < newLength; i++) {
                newArr[i] = arr[i];
            }
            return newArr;
        }


    }

}
