package com.aggregate;

import java.util.*;

public class AggregateQianTao {
    public static void main(String[] args) {
        /*定义一个Map集合，键用表示省份名称province，值表示市city，但是市会有多个。
            添加完毕后，遍历结果格式如下：
            江苏省 = 南京市，扬州市，苏州市，无锡市，常州市
            湖北省 = 武汉市，孝感市，十堰市，宜昌市，鄂州市
            河北省 = 石家庄市，唐山市，邢台市，保定市，张家口市*/

        HashMap<String, ArrayList<String>> hm = new HashMap<>();

        // 使用单列集合存储每个省份对应的城市
        ArrayList<String> city1 = new ArrayList<>();
        ArrayList<String> city2 = new ArrayList<>();
        ArrayList<String> city3 = new ArrayList<>();

        Collections.addAll(city1, "南京市", "扬州市", "苏州市", "无锡市", "常州市");
        Collections.addAll(city2, "武汉市", "孝感市", "十堰市", "宜昌市", "鄂州市");
        Collections.addAll(city3, "石家庄市", "唐山市", "邢台市", "保定市", "张家口市");

        hm.put("江苏省", city1);
        hm.put("湖北省", city2);
        hm.put("河北省", city3);

        Set<Map.Entry<String, ArrayList<String>>> set = hm.entrySet();

        for (Map.Entry<String, ArrayList<String>> entry : set){
            String cityName = entry.getKey();
            ArrayList<String> cityList = entry.getValue();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cityList.size(); i++){
                if (i == cityList.size() - 1){
                    sb.append(cityList.get(i));
                } else{
                    sb.append(cityList.get(i) + ", ");
                }

            }
            System.out.println(cityName + " = " + sb.toString());

        }
    }
}
