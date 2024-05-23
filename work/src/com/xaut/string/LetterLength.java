package com.xaut.string;

public class LetterLength {
    public static void main(String[] args) {
        /*给你一串字符串s，有若干个单词组成，单词前后用一些空格字符隔开（单个或多个）
        返回最后一个单词的长度，单词指仅由字母组成，不包含任何空格字符的最大子字符串*/

        String str = " Hello World  ";
        int length = 0;
        boolean flag = false; //标志着是否遇见字母
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                // 之前遇到过字母了，现在又遇到空格，说明单词已经统计完成
                if (flag){
                    break;
                }
            } else {
                flag = true;
                length++;
            }
        }
        System.out.println(length);
    }
}
