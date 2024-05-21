package com.xaut.method;

public class PrimeNumber {
    public static void main(String[] args) {
        /*判断101~200之间有多少个素数，并输出所有素数。*/

        int count = 0; //保存素数个数

        for (int i = 101; i <= 200; i++) {
            boolean isPrime = true;
            for (int j = 2; j < (i / 2); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                count++;
                System.out.print(i + " ");
            }

        }
        System.out.println();
        System.out.println("101-200之间的素数共有：" + count);
    }

}
