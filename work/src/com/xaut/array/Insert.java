package com.xaut.array;

import java.util.Scanner;

public class Insert {
    public static void main(String[] args) {
        /*有一个数组，其中有十个元素从小到大依次排列 {12,14,23,45,66,68,70,77,90,91}。
        再通过键盘录入一个整数数字。要求：把数字放入数组序列中，
        生成一个新的数组，并且数组的元素依旧是从小到大排列的。*/

        int[] arr = {12,14,23,45,66,68,70,77,90,91};
        //由于数组长度不能修改，所以定义一个新的数组保存结果，长度为原数组长度+1
        int[] res = new int[arr.length + 1];
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
//        int index = arr.length;  //记录用于存放number的位置
//        //将这个number插入到arr中，且保持这个数组依然有序
//        for (int i = 0 ; i < arr.length ; i++) {
//            //找到number在新数组中的位置
//            if (number <= arr[i]) {
//                index = i;
//                break;
//            }
//        }
//        //开始存放
//        for (int i = 0 ; i < res.length ; i++) {
//            if (i < index) {
//                res[i] = arr[i];
//            }else if (i == index) {
//                res[i] = number;
//            }else{
//                res[i] = arr[i - 1];
//            }
//        }

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= number){
                res[i] = arr[i];
                index = i + 1;
            }else{
                res[i + 1] = arr[i];
            }
        }
        res[index] = number;
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}
