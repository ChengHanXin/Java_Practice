package com.xaut.studentsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void start() {
        /*#### 添加功能：
            键盘录入每一个学生信息并添加，需要满足以下要求：
            id唯一
        #### 删除功能：
        键盘录入要删除的学生id，需要满足以下要求：
        * id存在删除
        * id不存在，需要提示不存在，并回到初始菜单

        #### 修改功能：
        键盘录入要修改的学生id，需要满足以下要求
        * id存在，继续录入其他信息
        * id不存在，需要提示不存在，并回到初始菜单

        #### 查询功能：
        打印所有的学生信息，需要满足以下要求
        * 如果没有学生信息，提示：当前无学生信息，请添加后再查询
        * 如果有学生信息，需要按照以下格式输出。（不用过于纠结对齐的问题）*/

        ArrayList<Student> students = new ArrayList<Student>();

        loop: while (true) {
            System.out.println("----------学生管理系统----------");
            System.out.println("1：添加学生");
            System.out.println("2：删除学生");
            System.out.println("3：修改学生");
            System.out.println("4：查询学生");
            System.out.println("5：退出");
            System.out.println("请输入您的选择:");
            Scanner sc = new Scanner(System.in);
            String choice = sc.next();
            switch (choice) {
                case "1" -> addStudent(students);
                case "2" -> delStudent(students);
                case "3" -> updateStudent(students);
                case "4" -> querryStudent(students);
                case "5" -> {
                    System.out.println("退出系统");
                    //break loop;  //使用标记，退出相应的循环
                    System.exit(0);    //停止虚拟机运行
                }
                default -> System.out.println("没有这个功能，请重新选择");
            }
        }
    }

    public static ArrayList<Student> addStudent(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入新学生的id");
        String id;
        //判断id是否唯一
        while (true) {
            id = sc.next();
            if (students.contains(id)) {
                System.out.println("Id重复，请重新输入：");
            } else {
                break;
            }
        }
        System.out.println("请输入新学生的name");
        String name = sc.next();
        System.out.println("请输入新学生的age");
        int age = sc.nextInt();
        System.out.println("请输入新学生的address");
        String address = sc.next();

        Student newStudent = new Student(id, name, age, address);
        students.add(newStudent);
        return students;

    }

    public static void delStudent(ArrayList<Student> students) {
        System.out.println("请输入要删除的学生Id:");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int index = getIndex(students, id);
        if (index == -1) {
            System.out.println("该学生不存在");
        } else {
            students.remove(index);
            System.out.println("删除成功");
        }

    }

    public static void updateStudent(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改学生的Id:");
        String id = sc.next();
        int index = getIndex(students, id);
        if (index == -1) {
            System.out.println("该学生不存在");
            return;
        } else {
            Student student = students.get(index);
            student.setId(id);
            System.out.println("请输入新的学生name:");
            String name = sc.next();
            student.setName(name);
            System.out.println("请输入新的学生age:");
            int age = sc.nextInt();
            student.setAge(age);
            System.out.println("请输入新的学生address:");
            String address = sc.next();
            student.setAddress(address);
        }
    }

    public static void querryStudent(ArrayList<Student> students) {
        if (students.size() == 0){
            System.out.println("当前无学生信息，请添加后再查询");
        } else {
            System.out.println("id\t\t姓名\t\t年龄\t\t家庭住址");
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i).getId() + '\t' + students.get(i).getName() +
                        '\t' + students.get(i).getAge() +'\t' + students.get(i).getAddress());
            }
        }
    }

    public static boolean contains(ArrayList<Student> students, String id) {
//        for (int i = 0; i < students.size(); i++) {
//            if (students.get(i).getId().equals(id)) {
//                return true;
//            }
//        }
//        return false;
        return getIndex(students, id) >= 0;
    }

    public static int getIndex(ArrayList<Student> students, String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
