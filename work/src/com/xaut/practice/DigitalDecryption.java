package com.xaut.practice;

public class DigitalDecryption {
    public static void main(String[] args) {
        /*对DigitalEncryption中加密的数字进行解密
        * 翻转-->余数-->减5*/

        int number = 8346;  //待解密数字
        int temp = number;
        //讲数字存储在数组中
        int count = 0;
        while (number > 0) {
            number = number / 10;
            count++;
        }
        int[] numbers = new int[count];
        //翻转数字
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = temp % 10;
            temp = temp / 10;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= 5 ) {
                numbers[i] -= 5;
            }else{
                numbers[i] += 5;
            }
        }
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result *= 10;
            result += numbers[i];
        }
        System.out.println(result);
    }
}
