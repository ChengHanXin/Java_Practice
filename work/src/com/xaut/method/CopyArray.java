package com.xaut.method;

public class CopyArray {
    public static void main(String[] args) {
        /*给定要给数组，将其[from, to)索引的数据拷贝到一个新的数组并将其返回*/
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] newArr = copyArray(arr, 0, 3);
        //打印拷贝的结果
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }

    }
    public static int[] copyArray(int[] arr, int from, int to) {
        //定义一个新数组，用来保存拷贝结果
        int[] newArr = new int[to - from];
        //循环遍历[from, to)索引的arr数组，将其拷贝到新数组中
        for (int i = from; i < to; i++) {
            newArr[i - from] = arr[i];
        }
        return newArr;
    }
}
