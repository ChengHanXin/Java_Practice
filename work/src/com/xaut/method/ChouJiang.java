package com.xaut.method;

import java.util.Random;

public class ChouJiang {
    public static void main(String[] args) {
        /*一个大V直播抽奖，奖品是现金红包，分别有{2,588,888,1000,10000}五个奖金。
        请使用代码模拟抽奖，打印出每个奖项，奖项的出现顺序要随机且不重复。打印效果如下：（随机顺序，不一定是下面的顺序）
            888元的奖金被抽出
            588元的奖金被抽出
            10000元的奖金被抽出
            1000元的奖金被抽出
            2元的奖金被抽出*/

//        int[] money = {2,588,888,1000,10000};
//        int[] arr = new int[money.length];
//        int index = 0;      //用来存储抽中了几个奖
//        Random rm = new Random();
//        //因为随机的可能是抽过的奖金，因此不知道循环的次数，使用while循环
//        while (index < money.length) {
//            int rodam = rm.nextInt(money.length);
//            //判断该金额有没有被抽取
//            boolean flag = panDuan(arr, rodam);
//            if (flag) {
//                System.out.println(money[rodam] + "元的奖金被抽出") ;
//                arr[rodam] = 1;
//                index++;
//            }
//        }
//    }
//
//    public static boolean panDuan(int[] arr, int rodam) {
//        if (arr[rodam] == 1){
//            return false;
//        }else {
//            return true;
//        }
//    }

        //思路二：直接打乱奖池，然后遍历奖池
        int[] money = {2,588,888,1000,10000};
        Random random = new Random();
        for (int i = 0; i < money.length; i++) {
            int index = random.nextInt(money.length);
            int temp = money[i];
            money[i] = money[index];
            money[index] = temp;
        }
        for (int i = 0; i < money.length; i++) {
            System.out.println(money[i]);
        }
    }

}
