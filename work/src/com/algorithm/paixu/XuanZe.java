package com.algorithm.paixu;

public class XuanZe {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 6, 1};
        //升序
//        for (int j = 0; j < arr.length - 1; j++) {
//            for (int i = j; i < arr.length - 1; i++) {
//                if (arr[i] > arr[i + 1]) {
//                    int temp = arr[i];
//                    arr[i] = arr[i + 1];
//                    arr[i + 1] = temp;
//                    //一旦发生交换，i置0
//                    i = 0;
//                }
//            }
//        }

        //i:表示这一轮中，我拿着哪个索引上的数据跟后面的数据进行比较并交换
        for (int i = 0; i < arr.length - 1; i++) {
            //拿着i跟i后面的数据进行比较交换
            for (int j = i + 1; j < arr.length; j++) {
                //本次将较小值放到第一位，此时第一位元素更新，然后下次循环拿的就是更新后的较小值与接下来的元素进行比较
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();

        }


    }
}
