package com.xaut.test;

import java.util.Scanner;

public class BiJiao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        int max = 0;

        //比较前两个数
//        max = n1 > n2 ? n1 : n2;
//        //比较max与第三个数的大小
//        max = max > n3 ? max : n3;
//        System.out.println(max);
        if (n1 > n2 && n1 > n3) {
            max = n1;
        }else if (n2 > n1 && n2 > n3){
            max = n2;
        }else{
            max = n3;
        }
        System.out.println(max);
    }
}
