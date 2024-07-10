package com.iostream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NumberSort {
    /*文本文件中有以下的数据：
                2-1-9-4-7-8
    将文件中的数据进行排序，变成以下的数据：
                1-2-4-7-8-9*/
    public static void main(String[] args) throws IOException {
        // 读取文件内容
        FileReader fr = new FileReader("else/source/a.txt");
        StringBuilder sb = new StringBuilder();
        int ch;
        while((ch = fr.read()) != -1 ){
            sb.append((char)ch);
        }

        fr.close();

        String[] s = sb.toString().split("-");

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < s.length; i++) {
            list.add(Integer.parseInt(s[i]));
        }

        // 排序
        Collections.sort(list);

        // 写回原文件
        FileWriter fw = new FileWriter("else/source/a.txt");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                fw.write(list.get(i) + "");
            } else{
                fw.write(list.get(i) + "-");
            }
        }

        fw.close();

//        System.out.println(list);



    }
}
