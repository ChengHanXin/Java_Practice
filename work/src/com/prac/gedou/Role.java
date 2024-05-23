package com.prac.gedou;

import java.util.Random;

public class Role {
    /*需求:
        格斗游戏，每个游戏角色的姓名，血量，都不相同，在选定人物的时候（new对象的时候），这些信息就应该被确定下来。
      */

    private String name;
    private int blood;
    private char gender;
    private String face;      //随机长相

    //男生长相数组
    String[] boyfaces = {"风流俊雅", "气宇轩昂", "相貌英俊", "五官端正", "相貌平平", "一塌糊涂", "面目狰狞"};
    //女生长相数组
    String[] girlfaces = {"美奂绝伦", "沉鱼落雁", "婷婷玉立", "身材娇好", "相貌平平", "相貌简陋", "惨不忍睹"};

    //attack 攻击描述：
    String[] attacks_desc = {
            "%s使出了一招【背心钉】，转到对方的身后，一掌向%s背心的灵台穴拍去。",
            "%s使出了一招【游空探爪】，飞起身形自半空中变掌为抓锁向%s。",
            "%s大喝一声，身形下伏，一招【劈雷坠地】，捶向%s双腿。",
            "%s运气于掌，一瞬间掌心变得血红，一式【掌心雷】，推向%s。",
            "%s阴手翻起阳手跟进，一招【没遮拦】，结结实实的捶向%s。",
            "%s上步抢身，招中套招，一招【劈挂连环】，连环攻向%s。"
    };

    //injured 受伤描述：
    String[] injureds_desc = {
            "结果%s退了半步，毫发无损",
            "结果给%s造成一处瘀伤",
            "结果一击命中，%s痛得弯下腰",
            "结果%s痛苦地闷哼了一声，显然受了点内伤",
            "结果%s摇摇晃晃，一跤摔倒在地",
            "结果%s脸色一下变得惨白，连退了好几步",
            "结果『轰』的一声，%s口中鲜血狂喷而出",
            "结果%s一声惨叫，像滩软泥般塌了下去"
    };

    public Role() {

    }
    public Role(String name, int blood, char gender) {
        if (name != null) {
            this.name = name;
        }else {
            System.out.println("name is null");
        }

        if (blood > 0) {
            this.blood = blood;
        } else {
            System.out.println("blood 小于0");
        }

        this.gender = gender;
        setFace(gender);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBlood() {
        return blood;
    }
    public void setBlood(int blood) {
        this.blood = blood;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public String getFace() {
        return face;
    }
    public void setFace(char gender) {
        if (gender == '男'){
            Random r = new Random();
            int index = r.nextInt(boyfaces.length);
            this.face = boyfaces[index];
        } else if (gender == '女'){
            Random r = new Random();
            int index = r.nextInt(girlfaces.length);
            this.face = girlfaces[index];
        } else {
            this.face = "面目狰狞";
        }
    }

    public void showRoleInfo(){
        System.out.println("名字为：" + this.name);
        System.out.println("血量为：" + this.blood);
        System.out.println("性别为：" + this.gender);
        System.out.println("长相为：" + this.face);
    }

    //攻击方法
    public void attack(Role role) {
        //攻击力为1-20之间的随机值
        Random random = new Random();
        int hurt = random.nextInt(20) + 1;
        //开始攻击，并修改被攻击者的血量
        int remainBlood = role.getBlood() - hurt;
        remainBlood = remainBlood > 0 ? remainBlood : 0;
        role.setBlood(remainBlood);

        //随机攻击手段
        int index = random.nextInt(attacks_desc.length);
        String desc = attacks_desc[index];
        System.out.printf(desc, this.name, role.getName());
        System.out.println();

        if (remainBlood > 90) {
            System.out.printf(injureds_desc[0], role.getName());
        } else if (remainBlood > 80 && remainBlood <= 90) {
            System.out.printf(injureds_desc[1], role.getName());
        } else if (remainBlood > 70 && remainBlood <= 80) {
            System.out.printf(injureds_desc[2], role.getName());
        } else if (remainBlood > 60 && remainBlood <= 70) {
            System.out.printf(injureds_desc[3], role.getName());
        } else if (remainBlood > 40 && remainBlood <= 60) {
            System.out.printf(injureds_desc[4], role.getName());
        } else if (remainBlood > 20 && remainBlood <= 40) {
            System.out.printf(injureds_desc[5], role.getName());
        } else if (remainBlood > 10 && remainBlood <= 20) {
            System.out.printf(injureds_desc[6], role.getName());
        } else {
            System.out.printf(injureds_desc[7], role.getName());
        }

        System.out.println();
//        System.out.println(this.name + "举起拳头打了" + role.getName() + "一下，造成了" + hurt + "点伤害，"
//                + role.getName()+ "还剩下" + role.getBlood() + "点血");
    }
}
