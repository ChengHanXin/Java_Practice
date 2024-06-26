package com.xaut.api;

public class Test2 {
    /*自己实现parseInt方法的效果，将字符串形式的数据转成整数。要求:字符串中只能是数字不能有其他字符最少一位，最多10位，0不能开头*/

    public static void main(String[] args) {
        String str = "1235";
        System.out.println(parseInt(str));
    }

    public static int parseInt(String str) {
        //首先过滤掉非法数据
        String regex = "[1-9]\\d{0,9}";
        int res = 0;
        if (! str.matches(regex)) {
            System.out.println("数据有误");
            return -1;
        } else{
            for (int i = 0; i < str.length(); i++) {
                res *= 10;
                res += str.charAt(i) - '0';
            }
        }
        return res;
    }
}
