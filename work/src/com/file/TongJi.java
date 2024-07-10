package com.file;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TongJi {

    public static void main(String[] args) {
        /*需求：统计一个文件夹中每种文件的个数并打印。（考虑子文件夹）
            打印格式如下：
            txt:3个
            doc:4个
            jpg:6个*/
        File file = new File("C:\\Users\\user\\Desktop\\java");
        HashMap<String, Integer> map = new HashMap<>();
        map = getCount(file);
        map.forEach((k, v) -> System.out.println(k + ":" + v + "个"));

    }


    /*
     * 作用：
     *       统计一个文件夹中每种文件的个数
     * 参数：
     *       要统计的那个文件夹
     * 返回值：
     *       用来统计map集合
     *       键：后缀名 值：次数
     *
     *       a.txt
     *       a.a.txt
     *       aaa（不需要统计的）
     * */
    public static HashMap<String, Integer> getCount(File file){
        File[] files = file.listFiles();
        HashMap<String,Integer> map = new HashMap<>();

        for(File f : files){
            // 如果是文件
            if(f.isFile()){
                String[] name = f.getName().split("\\.");
                // 判断是否符合统计要求
                if (name.length >= 2) {
                    // 获取文件后缀
                    String last = name[name.length - 1];
                    // 更新map
                    // 如果map中已经统计过，更新值
                    if (map.containsKey(last)) {
                        map.put(last, map.get(last) + 1);
                    } else{
                        map.put(last, 1);
                    }
                }
            } else {
                HashMap<String,Integer> temp = new HashMap<>();
                temp = getCount(f);
                // 遍历这个返回结果，更新map
                Set<Map.Entry<String, Integer>> set = temp.entrySet();
                for (Map.Entry<String, Integer> entry : set) {
                    String key = entry.getKey();
                    int value = entry.getValue();
                    if (map.containsKey(key)) {
                        map.put(key, map.get(key) + value);
                    } else{
                        map.put(key, value);
                    }
                }
            }
        }
        return map;
    }
}
