package com.jiekou.a03;

/*使用继承、抽象类和接口实现以下关系：
* 乒乓球运动员  姓名、年龄   学打乒乓球、说英语
* 篮球运动员    姓名、年龄   学打篮球
* 乒乓球教练    姓名、年龄   教打乒乓球、说英语
* 篮球教练     姓名、年龄    教打篮球*/

/*                   person（姓名、年龄）
*     乒乓球从业者（说英语）              篮球从业者
* 乒乓球运动员   乒乓球教练员       篮球运动员    篮球教练员
* interface1:teach              interface2:learn*/

/*                   person（姓名、年龄）
 *        运动员（学）                 教练（教）
 * 乒乓球运动员   篮球运动员       乒乓球教练   篮球教练
 *                   interface:SpeakEnglish       */


public class Test {
    public static void main(String[] args) {
        PingPangSporter pingPangSporter = new PingPangSporter("邓亚萍", 25);
        System.out.println(pingPangSporter.getName() + "  " + pingPangSporter.getAge());
        pingPangSporter.learn();
        pingPangSporter.speak();

        BasketballCoach basketballCoach = new BasketballCoach("姚明", 36);
        System.out.println(basketballCoach.getName() + "  " + basketballCoach.getAge());
        basketballCoach.teach();
    }
}
