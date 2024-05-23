package com.xaut.string;

public class StringMulti {
    public static void main(String[] args) {
        /*给定两个以字符串形式表示的非负整数num1和num2，返回二者的乘积（字符串形式）*/

        String num1 = "123";
        String num2 = "2";

        //1.将每个字符串转换为对应的数字
        int n1 = stringToNumber(num1);
        int n2 = stringToNumber(num2);
        int res = n1 * n2;

        //将数组转换回字符串
        System.out.println(res + "");
    }

    public static int stringToNumber(String str){
        int res = 0;
        for(int i = 0; i < str.length(); i++){
            res = res * 10 + (str.charAt(i) - 48);
        }
        return res;
    }
}
