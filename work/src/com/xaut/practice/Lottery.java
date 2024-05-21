package com.xaut.practice;

import java.util.Random;
import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {
        /*投注号码由6个红色球号码和1个蓝色球号码组成。
            红色球号码从1—33中选择﹔蓝色球号码从1―16中选择。*/

        //生成中奖号码
        int[] arr = creatArr();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        //用户输入号码
        int[] inputArr = inputArray();

        int readCount = 0;
        int blueCount = 0;
        //判断中奖个数
        for (int i = 0; i < inputArr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[i] == inputArr[j]) {
                    readCount++;
                    break;
                }
            }
        }
        if (inputArr[inputArr.length - 1] == arr[arr.length - 1]) {
            blueCount++;
        }

        System.out.println(readCount);
        System.out.println(blueCount);
    }

    public static int[] creatArr(){
        int[] arr = new int[7];
        Random random = new Random();
        //生成红色中奖号码
        for (int i = 0; i < 6;) {
            int redNumber = random.nextInt(33) + 1;
            //判断号码是否合法
            if (redNumber >= 1 && redNumber <= 33) {
                boolean flag = contains(arr, redNumber);
                if (! flag){
                    arr[i] = redNumber;
                    i++;
                }
            }
        }
        //生成蓝色中奖号码
        int blueNumber = random.nextInt(16) + 1;
        arr[arr.length - 1] = blueNumber;

        return arr;
    }

    public static int[] inputArray(){
        int[] inputArr = new int[7];
        Scanner scanner = new Scanner(System.in);
        //输入红色号码
        for (int i = 0; i < 6;) {
            System.out.print("Enter " + (i + 1) + " red number: ");
            int redNumber = scanner.nextInt();
            //判断号码合法性
            if (redNumber >= 1 && redNumber <= 33) {
                boolean flag = contains(inputArr, redNumber);
                if (! flag){
                    inputArr[i] = redNumber;
                    i++;
                }else {
                    System.out.println("This number has in the arr!");
                }
            }else {
                System.out.println("Invalid red number!");
            }
        }

        //输入蓝色号码
        while (true){
            System.out.print("Enter blue number: ");
            int blueNumber = scanner.nextInt();
            if (blueNumber >= 1 && blueNumber <= 16) {
                inputArr[inputArr.length - 1] = blueNumber;
                break;
            }else {
                System.out.println("Invalid blue number!");
            }
        }

        return inputArr;
    }

    public static boolean contains(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }
}
