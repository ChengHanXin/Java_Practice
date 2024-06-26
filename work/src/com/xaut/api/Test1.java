package com.xaut.api;

import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        /*键盘录入一些1~100之间的整数，并添加到集合中。直到集合中所有数据和超过200为止。*/

        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(check(list)){
            String str = sc.nextLine();
            //将获取的字符串转换为int
            int temp = Integer.parseInt(str);
            if (temp < 1 || temp > 100){
                System.out.println("Error");
            } else {
                list.add(temp);  //自动装箱
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }

    public static boolean check(ArrayList<Integer> list){
        int sum = 0;
        for (int i = 0; i < list.size(); i++){
            sum += list.get(i);     //自动拆箱
            if (sum > 200){
                return false;
            }
        }
        return true;
    }
}
