package com.xaut.string;

public class AdjustString {
    public static void main(String[] args) {
        /*给定两个字符串，A和B
          旋转操作，即将一个字符串最左边的字符移到最右边
          如果在若干次调整之后，A能变成B，那么返回True，否则返回False*/

        String str1 = "abcd";
        String str2 = "bcda";
        boolean flag = false;
        //经过观察可知，当一个字符串旋转过其自身长度后，就与原始字符串相同，所以最多比较length次
        for (int i = 0; i < str1.length(); i++) {
            if (str1.equals(str2)) {
                flag = true;
                break;
            } else {
//                str1 = rotate1(str1);
                str1 = rotate2(str1);
            }

        }
        System.out.println(flag);

    }

    // 如果看到要修改字符串的内容
    // 1. 使用subString进行截取
    // 2. 先把字符串变成一个字符数组，然后调整字符数组中的内容，最后把字符数组变成字符串
    public static String rotate1(String str) {
        String first = str.charAt(0) + "";
        String remain = str.substring(1);
        return remain + first;
    }

    public static String rotate2(String str) {
        char[] chars = str.toCharArray();
        char first = chars[0];
        for (int i = 1; i < chars.length; i++) {
            chars[i - 1] = chars[i];
        }
        chars[chars.length - 1] = first;
        return new String(chars);
    }

}
