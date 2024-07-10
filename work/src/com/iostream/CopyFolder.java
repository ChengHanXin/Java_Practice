package com.iostream;

import java.io.*;

public class CopyFolder {
    /*
    *  拷贝一个文件夹的所有内容到另一个文件夹
    * */
    public static void main(String[] args) throws IOException {
        File source = new File("else/source");
        File destination = new File("else/destination");
        copyFolder(source, destination);

    }

    public static void copyFolder(File source, File destination) throws IOException {
        destination.mkdirs();
        File[] files = source.listFiles();

        for (File file : files) {
            // 如果是文件，直接复制
            if (file.isFile()){
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(destination, file.getName()));
                byte[] buffer = new byte[1024];
                int length = 0;
                while((length = fis.read(buffer)) != -1){
                    fos.write(buffer, 0, length);
                }
            } else {
                copyFolder(file, new File(destination, file.getName()));
            }
        }
    }

}
