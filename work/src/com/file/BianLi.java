package com.file;

import java.io.File;

public class BianLi {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\user\\Desktop\\java");
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }
}
