package com.jicheng.a01;

public class EmployeTest {
    public static void main(String[] args) {
        /*在黑马程序员中有很多员工(Employee)。
        按照工作内容不同分教研部员工(Teacher)和行政部员工(AdminStaff)
        1. 教研部根据教学的方式不同又分为讲师(Lecturer)和助教(Tutor)
        2. 行政部根据负责事项不同,又分为维护专员(Maintainer),采购专员(Buyer)
        3. 公司的每一个员工都编号,姓名和其负责的工作
        4. 每个员工都有工作的功能，但是具体的工作内容又不一样。*/

        Lecturer lecturer = new Lecturer("张三" , "001" , "讲师");
        lecturer.job();

        Buyer buyer = new Buyer("李四", "005", "采购员");
        buyer.job();
    }

}
