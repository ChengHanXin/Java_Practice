package com.xaut.test;

public class HuiWenNumber {
    public static void main(String[] args) {
        /*
            需求：输入一个数，判断其是不是回文数。
            eg: 121, 222, 4994
        */
        int x = 1;
        //用于最终与得到的反转数进行比较
        int temp = x;
        //定义翻转后的数字
        int result = 0;
        while(x != 0){
            //获取数字的最低位
            int low = x % 10;
            //修改x
            x = x / 10;
            //更新翻转后的数字
            result = result * 10 + low;
        }
        //进行比较，是否为回文数
        System.out.println(temp == result);
    }
}
