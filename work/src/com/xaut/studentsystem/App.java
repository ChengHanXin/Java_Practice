package com.xaut.studentsystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<User>();
        while (true) {
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作1登录 2注册 3忘记密码 4查看所有用户信息 5退出系统");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            switch (choice) {
                case "1" -> login(users);
                case "2" -> register(users);
                case "3" -> forgetPassword(users);
                case "4" -> printUser(users);
                case "5" -> System.exit(0);
                default -> System.out.println("系统没有此功能，请重新选择");
            }
        }

    }

    public static void login(ArrayList<User> users) {
        for (int i = 0; i < 2; i++) {
            System.out.println("请输入name");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            int index = getIndex(users, name);
            if (index == -1) {
                System.out.println("用户名未注册，请先注册");
                return;
            }
            System.out.println("请输入password");
            String password = scanner.next();

            while (true) {
                String code1 = getCode();
                System.out.println("验证码为：" + code1);
                System.out.println("请输入验证码");
                String code2 = scanner.next();
                if (code1.equals(code2)) {
                    break;
                } else {
                    System.out.println("验证码输入错误，请重新输入");
                }
            }

            // 查验name和password是否对应
            User user = users.get(index);
            if (user.getPassword().equals(password)){
                System.out.println("系统登录成功，欢迎您进行使用！");
                StudentSystem ss = new StudentSystem();
                ss.start();
            } else {
                System.out.println("密码错误，您还有" + (2 - i) + "次机会");
            }
        }

    }

    public static void register(ArrayList<User> users) {
        System.out.println("请输入用户名：");
        Scanner scanner = new Scanner(System.in);
        String name;
        while (true) {
            name = scanner.next();
            boolean falg1 = checkName(name);
            if (!falg1) {
                System.out.println("用户名不符合规范，请重新输入");
                continue;
            }
            //检查name唯一性
            boolean flag2 = contains(users, name);
            if (flag2) {
                System.out.println("当前name已存在，请重新输入");
                continue;
            } else {
                break;
            }
        }

        String p1;
        while (true) {
            System.out.println("请输入密码：");
            p1 = scanner.next();
            System.out.println("请再次输入密码：");
            String p2 = scanner.next();
            if (!p1.equals(p2)) {
                System.out.println("两次密码不一致，请重新输入");
            } else {
                break;
            }
        }

        String id;
        while (true) {
            System.out.println("请输入身份证号：");
            id = scanner.next();
            boolean flag = checkId(id);
            if (flag) {
                break;
            } else {
                System.out.println("身份证格式错误，请重新输入：");
            }
        }

        String phoneNumber;
        while (true) {
            System.out.println("请输入手机号：");
            phoneNumber = scanner.next();
            boolean flag = checkPhoneNumber(phoneNumber);
            if (flag) {
                break;
            } else {
                System.out.println("手机号码格式错误，请重新输入：");
            }
        }

        User user = new User(name, p1, id, phoneNumber);
        users.add(user);
//        printUser(users);
        System.out.println("注册成功！");
    }

    public static void forgetPassword(ArrayList<User> users) {
        System.out.println("请输入name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int index = getIndex(users, name);
        if (index == -1) {
            System.out.println("该用户未注册");
            return;
        }
        System.out.println("请输入身份证号码：");
        String id = scanner.next();
        System.out.println("请输入手机号码：");
        String phoneNumber = scanner.next();
        User user = users.get(index);
//        System.out.println(user.getPhoneNumber() + " " + user.getId());
        if (user.getPhoneNumber().equals(phoneNumber) && user.getId().equals(id)) {
            System.out.println("请输入新密码：");
            String newPassword = scanner.next();
            user.setPassword(newPassword);
        } else {
            System.out.println("账号信息不匹配，修改失败");
        }

    }

    public static boolean checkName(String name) {
        /*用户名长度必须在3~15位之间
        只能是字母加数字的组合，但是不能是纯数字*/
        int len = name.length();
        if (len < 3 || len > 15){
            return false;
        }

        for (int i = 0; i < len; i++) {
            char ch = name.charAt(i);
            if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))) {
                return false;
            }
        }

        for (int i = 0; i < len; i++) {
            char ch = name.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(ArrayList<User> users, String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkId(String id) {
        //长度为18位  不能以0为开头  前17位，必须都是数字  最为一位可以是数字，也可以是大写X或小写x
        int len = id.length();
        if (len != 18){
            return false;
        }

        for (int i = 0; i < len - 1; i++) {
            char ch = id.charAt(i);
            if (ch >= '0' && ch <= '9') {
                continue;
            } else {
                return false;
            }
        }

        char endChar = id.charAt(len - 1);
        if ((endChar >= '0' && endChar <= '9') || endChar == 'x' || endChar == 'X') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        //长度为11位  不能以0为开头  必须都是数字
        int len = phoneNumber.length();
        if (len != 11){
            return false;
        }

        if (phoneNumber.charAt(0) == '0'){
            return false;
        }
        for (int i = 0; i < len - 1; i++) {
            char ch = phoneNumber.charAt(i);
            if (!(ch >= '0' && ch <= '9')) {
                return false;
            }
        }
        return true;
    }

    public static void printUser(ArrayList<User> users) {
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getName() + " " + users.get(i).getPhoneNumber() + " " + users.get(i).getId() + " " + users.get(i).getPassword());
        }
    }

    public static int getIndex(ArrayList<User> users, String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public static String getCode() {
        //长度为5  由4位大写或者小写字母和1位数字组成，同一个字母可重复  数字可以出现在任意位置
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i));
            list.add((char)('A' + i));
        }

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(list.size());
            sb.append(list.get(index));
        }
        sb.append(random.nextInt(10));
        char[] ch = sb.toString().toCharArray();

        //打乱顺序
        int randomIndex = random.nextInt(ch.length);
        char temp = ch[ch.length - 1];
        ch[ch.length - 1] = ch[randomIndex];
        ch[randomIndex] = temp;

        return new String(ch);
    }
}
