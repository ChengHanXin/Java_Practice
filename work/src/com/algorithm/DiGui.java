package com.algorithm;

public class DiGui {
    public static void main(String[] args) {
        //使用递归算法求解1-100的和
        System.out.println(getSum(100));

    }

    public static int getSum(int number){
        if (number == 1){
            return 1;
        }

        return number + getSum(number - 1);
    }
}
