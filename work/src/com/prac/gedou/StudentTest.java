package com.prac.gedou;

public class StudentTest {
    public static void main(String[] args) {
        /*定义一个长度为3的数组，数组存储1~3名学生对象作为初始数据，学生对象的学号，姓名各不相同。
            学生的属性：学号，姓名，年龄。
            要求1：再次添加一个学生对象，并在添加的时候进行学号的唯一性判断。
            要求2：添加完毕之后，遍历所有学生信息。
            要求3：通过id删除学生信息 如果存在，则删除，如果不存在，则提示删除失败。
            要求4：删除完毕之后，遍历所有学生信息。
            要求5：查询数组id为“heima002”的学生，如果存在，则将他的年龄+1岁*/

        Student[] stu = new Student[3];
        stu[0] = new Student(1, "lihua", 18);
        stu[1] = new Student(2, "xiaomei", 19);

        //添加一个学生对象
        Student newStu = new Student(3, "keda", 20);
        //判断唯一性
        boolean flag = contains(stu, newStu.getId());
        if (flag) {
            System.out.println("id重复，添加失败");
        } else {
            //获取当前数组中存放的对象个数
            int nubmerItem = countItem(stu);
            if (nubmerItem < 3) {
                //数组没有存放满，直接存放
                stu[nubmerItem] = newStu;
                printArr(stu);
            } else {
                Student[] newArr = creatNewArr(stu);
                newArr[nubmerItem] = newStu;
                printArr(newArr);
            }
        }

        //通过id删除学生， 为了方便演示，直接在stu数组上操作
        int index = findIndex(stu, 3);
        if (index == -1) {
            System.out.println("该id不存在，删除失败");
        } else {
            stu[index] = null;
        }
        printArr(stu);

        //查询数组id为“2”的学生，如果存在，则将他的年龄+1岁
        int index2 = findIndex(stu, 2);
        if (index2 == -1) {
            System.out.println("该学生不存在，修改失败");
        } else {
            stu[index2].setAge(stu[index2].getAge() + 1);
        }
        printArr(stu);

    }

    public static boolean contains(Student[] stu, int id) {
        for (int i = 0; i < stu.length; i++) {
            if (stu[i] != null) {
                if (stu[i].getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int countItem(Student[] stu){
        int count = 0;
        for(int i = 0; i < stu.length; i++){
            if(stu[i] != null){
                count++;
            }
        }
        return count;
    }

    public static Student[] creatNewArr(Student[] stu){
        Student[] newArr = new Student[stu.length + 1];
        for (int i = 0; i < stu.length; i++){
            newArr[i] = stu[i];
        }
        return newArr;
    }

    public static void printArr(Student[] stu){
        for (int i = 0; i < stu.length; i++) {
            if (stu[i] != null) {
                System.out.println(stu[i].getId() + ", " + stu[i].getName() + ", " + stu[i].getAge());
            }
        }
    }

    public static int findIndex(Student[] stu, int id) {
        for (int i = 0; i < stu.length; i++) {
            if (stu[i] != null){
                if (stu[i].getId() == id) {
                    return i;
                }
            }
        }
        return -1;
    }
}
