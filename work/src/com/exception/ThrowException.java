package com.exception;

public class ThrowException {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {};
        int max = 0;
        try {
            max = getMax(arr);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println(max);
        System.out.println("代码还可以执行");

    }

    public static int getMax(int[] arr) throws NullPointerException, ArrayIndexOutOfBoundsException {
//        if (arr == null){
//            throw new NullPointerException("arr is null");
//        }
//        if (arr.length == 0){
//            throw new ArrayIndexOutOfBoundsException("arr is empty");
//        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
