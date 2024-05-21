package com.xaut.practice;

public class DigitalEncryption {
    public static void main(String[] args) {
        /*需求：
	        某系统的数字密码（大于0），比如1983，采用加密方式进行传输。
        规则如下：
            先得到每位数，然后每位数都加上5 , 再对10求余，最后将所有数字反转，得到一串新数。*/

        int number = 1983;  //原始待加密数字
        int temp = number;
        //先将数字的每个位存放到数组中，容易批量处理
        //先获取数字位数，用来定义数组
        int count = 0;
        while (number > 0) {
            number = number / 10;
            count++;
        }
        //System.out.println(count);
        int[] numbers = new int[count];
        for (int i = numbers.length-1; i >= 0; i--) {
            numbers[i] = temp % 10;
            temp = temp / 10;
        }

        // 加5，对10求余
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (numbers[i] + 5) % 10;
        }

        //翻转所有数字
        for (int i = 0, j = numbers.length - 1; i < j; i++, j--) {
            int t = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = t;
        }

        //拼接数组中的数字，返回结果
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result *= 10;
            result += numbers[i];
        }
        System.out.println(result);
    }
}
