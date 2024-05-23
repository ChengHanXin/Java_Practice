package com.prac.gedou;

public class GameTest {
    public static void main(String[] args) {
        /* 举例：
        程序运行之后结果为：
        姓名为:乔峰		血量为:100
        姓名为:鸠摩智	血量为:100
        乔峰举起拳头打了鸠摩智一下，造成了XX点伤害，鸠摩智还剩下XXX点血。
        鸠摩智举起拳头打了鸠摩智一下，造成了XX点伤害，乔峰还剩下XXX点血。
        乔峰举起拳头打了鸠摩智一下，造成了XX点伤害，鸠摩智还剩下XXX点血。
        鸠摩智举起拳头打了鸠摩智一下，造成了XX点伤害，乔峰还剩下XXX点血。
        乔峰K.O.了鸠摩智*/

        Role r1 = new Role("乔峰", 100, '男');
        Role r2 = new Role("鸠摩智", 100, '男');
        r1.showRoleInfo();
        r2.showRoleInfo();
        //开始游戏
        while(true){
            r1.attack(r2);
            if (r2.getBlood() == 0){
                System.out.println(r1.getName() + "K.O.了" + r2.getName());
                break;
            }

            r2.attack(r1);
            if (r1.getBlood() == 0){
                System.out.println(r2.getName() + "K.O.了" + r1.getName());
                break;
            }
        }
    }
}
