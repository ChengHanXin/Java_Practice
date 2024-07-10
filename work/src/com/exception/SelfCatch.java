package com.exception;

public class SelfCatch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        try{
            System.out.println(arr[6]);
            System.out.println(10.0/0);
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        } catch(ArithmeticException e){
            System.out.println(e);
        }

        System.out.println("我执行了哦");
    }
}
